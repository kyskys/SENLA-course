package service;

import entities.Garage;
import entities.Sit;
import manager.StorageManager;
import service.intefraces.IGarageService;
import storage.SitStorage;
import storage.interfaces.IAbstractStorage;
import storage.interfaces.IGarageStorage;

public class GarageService extends AbstractService<Garage> implements IGarageService {

	private IGarageStorage garageStorage = StorageManager.getGarageStorage();
	private SitStorage sitStorage = StorageManager.getSitStorage();

	@Override
	public IAbstractStorage<Garage> getStorage() {
		return garageStorage;
	}

	@Override
	public void addSitToGarage(Long idGarage) {
		Garage garage = garageStorage.get(idGarage);
		Sit sit = new Sit(garage);
		if (sitStorage.create(sit)) {
			garage.addSit(sit);
		}
	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) {
		Garage garage = garageStorage.get(idGarage);
		Sit sit = sitStorage.get(idSit);
		garage.removeSit(sit);
		sitStorage.delete(idSit);
	}

}
