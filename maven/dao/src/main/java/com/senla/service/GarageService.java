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
	public void addSitToGarage(Long idGarage, Long idSit) throws Throwable {
		executeSimpleTransactionAction(session -> {
			Garage garage = garageStorage.get(session, idGarage);
			Sit sit = sitStorage.get(session, idSit);
			garage.addSit(sit);
			sit.setGarage(garage);
			garageStorage.update(session, garage);
			sitStorage.update(session, sit);
		});
	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) throws Throwable {
		executeSimpleTransactionAction(session -> {
			Garage garage = garageStorage.get(session, idGarage);
			Sit sit = sitStorage.get(session, idSit);
			garage.removeSit(sit);
			garageStorage.update(session, garage);
			sitStorage.delete(session, sit);
		});
	}

}
