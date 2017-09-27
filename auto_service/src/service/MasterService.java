package service;

import counter.Counter;
import entities.Master;
import service.intefraces.IMasterService;
import storage.interfaces.IMasterStorage;
import storage.interfaces.ISortableStorage;

public class MasterService extends SortableService<Master> implements IMasterService {
	IMasterStorage masterStorage = Counter.getMasterStorage();

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

}
