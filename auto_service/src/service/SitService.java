package service;

import java.util.Date;

import counter.Counter;
import entities.Sit;
import service.intefraces.ISitService;
import storage.SitStorage;
import storage.interfaces.IAbstractStorage;
import util.Utils;

public class SitService extends AbstractService<Sit> implements ISitService {
	private SitStorage sitStorage = Counter.getSitStorage();

	@Override
	public IAbstractStorage<Sit> getStorage() {
		return sitStorage;
	}

	public void showAvailableList() {
		System.out.println(Utils.getListAsString(sitStorage.getFreeSitsOnDate(new Date())));
	}

	public void showFreeSitsAtDate(Date date) {
		System.out.println(Utils.getListAsString(sitStorage.getFreeSitsOnDate(date)));
	}

}
