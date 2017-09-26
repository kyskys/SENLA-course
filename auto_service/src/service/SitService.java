package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Sit;
import service.intefraces.ISitService;
import storage.MasterStorage;
import storage.ServiceStorage;
import storage.SitStorage;

public class SitService implements ISitService {
	private SitStorage ss = ServiceStorage.getSitStorage();
	private MasterStorage ms = ServiceStorage.getMasterStorage();

	public void showAvailableList() {
		ss.getFreeSitsOnDate(new Date());

		System.out.println("in garages available List: " + "");
	}

	public void showFreeSitsAtDate(Date date) {
		List<Sit> sits = ss.getFreeSitsOnDate(date);
		List<Master> masters = ms.getFreeMastersOnDate(date);
	}
}
