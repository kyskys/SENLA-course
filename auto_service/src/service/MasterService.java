package service;

import entities.Master;
import entities.Order;
import manager.StorageManager;
import service.intefraces.IMasterService;
import storage.interfaces.IMasterStorage;
import storage.interfaces.IOrderStorage;
import storage.interfaces.ISortableStorage;

public class MasterService extends SortableService<Master> implements IMasterService {
	private IMasterStorage masterStorage = StorageManager.getMasterStorage();
	private IOrderStorage orderStorage = StorageManager.getOrderStorage();

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) {
		return masterStorage.getOrderExecutingByConcreteMaster(id);
	}

}
