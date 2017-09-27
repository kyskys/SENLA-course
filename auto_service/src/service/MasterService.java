package service;

import entities.Master;
import manager.StorageManager;
import service.intefraces.IMasterService;
import sort.SortParameters;
import storage.interfaces.IMasterStorage;
import storage.interfaces.IOrderStorage;
import storage.interfaces.ISortableStorage;
import util.Utils;

public class MasterService extends SortableService<Master> implements IMasterService {
	private IMasterStorage masterStorage = StorageManager.getMasterStorage();
	private IOrderStorage orderStorage = StorageManager.getOrderStorage();

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

	@Override
	public String showMasters(String parameter) {
		return Utils.getListAsString(masterStorage.getAll(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String showOrderExecutingByConcreteMaster(Long id) {
		return masterStorage.getOrderExecutingByConcreteMaster(id).getId().toString();
	}

}
