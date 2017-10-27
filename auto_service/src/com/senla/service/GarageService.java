package com.senla.service;

import com.senla.entities.Garage;
import com.senla.entities.Sit;
import com.senla.service.interfaces.IGarageService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IGarageStorage;
import com.senla.storage.interfaces.ISitStorage;

import dependency.DependencyManager;

public class GarageService extends AbstractService<Garage> implements IGarageService {

	private IGarageStorage garageStorage = DependencyManager.getInstance(IGarageStorage.class);
	private ISitStorage sitStorage = DependencyManager.getInstance(ISitStorage.class);

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
