package service;

import counter.Counter;
import entities.Garage;
import service.intefraces.IGarageService;
import storage.interfaces.IAbstractStorage;
import storage.interfaces.IGarageStorage;

public class GarageService extends AbstractService<Garage> implements IGarageService {

	IGarageStorage garageStorage = Counter.getGarageStorage();

	@Override
	public IAbstractStorage<Garage> getStorage() {
		return garageStorage;
	}

}
