package com.senla.service;

import com.senla.entities.Garage;
import com.senla.entities.Sit;
import com.senla.service.interfaces.IGarageService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IGarageStorage;
import com.senla.storage.interfaces.ISitStorage;

import annotation.Injectable;

public class GarageService extends AbstractService<Garage> implements IGarageService {
	@Injectable
	private IGarageStorage garageStorage;
	@Injectable
	private ISitStorage sitStorage;

	@Override
	public IAbstractStorage<Garage> getStorage() {
		return garageStorage;
	}

	@Override
	public void addSitToGarage(Long idGarage, Long idSit) {
		Garage garage = garageStorage.get(idGarage);
		Sit sit = sitStorage.get(idSit);
		if (!garage.getSits().contains(sit)) {
			garage.addSit(sit);
			sit.setGarage(garage);
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
