package service;

import java.util.Date;

import storage.ServiceStorage;
import storage.SitStorage;

public class SitService {
	private SitStorage ss = ServiceStorage.getSitStorage();

	public void showAvailableSits() {
		ss.showAvailableSits();
	}

	public void showAvailableSitsInFuture(Date date) {
		int availablesits = 0;
		for (int i = 0; i < ss.getSits().size(); i++) {
			if (ss.getSits().get(i).getOrder().getEndingDate().before(date)) {
				availablesits++;
			}
		}
	}
}
