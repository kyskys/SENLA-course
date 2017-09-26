package service;

import java.util.Date;

import service.intefraces.ISitService;
import storage.ServiceStorage;
import storage.SitStorage;

public class SitService implements ISitService{
	private SitStorage ss = ServiceStorage.getSitStorage();

	public void showAvailableList() {
		int availableList = 0;
		for (int i = 0; i < ss.getList().size(); i++) {
			if (ss.getList().get(i).getOrder().equals(null)) {
				availableList++;
			}
		}

		System.out.println("in garages available List: " + availableList);
	}

	public void showAvailableListInFuture(Date date) {
		int availableList = 0;
		for (int i = 0; i < ss.getList().size(); i++) {
			if (ss.getList().get(i).getOrder().getEndingDate().before(date)) {
				availableList++;
			}
		}
	}
}
