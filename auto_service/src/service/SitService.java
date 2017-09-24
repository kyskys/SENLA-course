package service;

import storage.ServiceStorage;
import storage.SitStorage;

public class SitService {
	private SitStorage ss = ServiceStorage.getSitStorage();
	public void showAvailableSits() {
		ss.showAvailableSits();
	}
}
