package service;

import entities.Garage;
import manager.StorageManager;
import service.intefraces.IGarageService;
import storage.interfaces.IAbstractStorage;
import storage.interfaces.IGarageStorage;

public class GarageService extends AbstractService<Garage> implements IGarageService {

	private IGarageStorage garageStorage = StorageManager.getGarageStorage();

	@Override
	public IAbstractStorage<Garage> getStorage() {
		return garageStorage;
	}
	
}
