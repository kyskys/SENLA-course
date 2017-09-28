package service;

import java.util.Date;
import java.util.List;

import entities.Sit;
import manager.StorageManager;
import service.intefraces.ISitService;
import storage.SitStorage;
import storage.interfaces.IAbstractStorage;

public class SitService extends AbstractService<Sit> implements ISitService {
	private SitStorage sitStorage = StorageManager.getSitStorage();

	@Override
	public IAbstractStorage<Sit> getStorage() {
		return sitStorage;
	}

	@Override
	public List<Sit> getFreeSits() {
		return sitStorage.getFreeSitsOnDate(new Date());
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) {
		return sitStorage.getFreeSitsOnDate(date);
	}

}
