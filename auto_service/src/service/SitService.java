package service;

import java.util.Date;

import storage.ServiceStorage;
import storage.SitStorage;

public class SitService {
	private SitStorage ss = ServiceStorage.getSitStorage();

	public void showAvailableSits() {
		int availableSits = 0;
		for (int i = 0; i < ss.getSits().size(); i++) {
			if (ss.getSits().get(i).getOrder().equals(null)) {
				availableSits++;
			}
		}

		System.out.println("in garages available sits: " + availableSits);
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
