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
import util.Utils;

public class SitService implements ISitService {
	private SitStorage ss = ServiceStorage.getSitStorage();
	private MasterStorage ms = ServiceStorage.getMasterStorage();

	public void showAvailableList() {
		System.out.println(Utils.getListAsString(ss.getFreeSitsOnDate(new Date())));
	}

	public void showFreeSitsAtDate(Date date) {
		System.out.println(Utils.getListAsString());
	}
}
