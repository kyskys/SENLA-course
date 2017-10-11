package service;

import entities.Garage;
import entities.Sit;
import service.intefraces.IGarageService;
import storage.interfaces.IAbstractStorage;
import storage.interfaces.IGarageStorage;
import storage.interfaces.ISitStorage;

public class GarageService extends AbstractService<Garage> implements IGarageService {

	private IGarageStorage garageStorage;
	private ISitStorage sitStorage;

	public GarageService(IGarageStorage garageStorage, ISitStorage sitStorage) {
		this.garageStorage = garageStorage;
		this.sitStorage = sitStorage;
	}

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
