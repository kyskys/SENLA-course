package service;

import java.util.Date;

import entities.Sit;
import manager.StorageManager;
import service.intefraces.ISitService;
import storage.SitStorage;
import storage.interfaces.IAbstractStorage;
import util.Utils;

public class SitService extends AbstractService<Sit> implements ISitService {
	private SitStorage sitStorage = StorageManager.getSitStorage();

	@Override
	public IAbstractStorage<Sit> getStorage() {
		return sitStorage;
	}

	@Override
	public String showFreeSits() {
		return Utils.getListAsString(sitStorage.getFreeSitsOnDate(new Date()));
	}

	@Override
	public String showFreeSitsAtDate(Date date) {
		return Utils.getListAsString(sitStorage.getFreeSitsOnDate(date));
	}

}
