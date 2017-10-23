package com.senla.manager;

import com.senla.manager.interfaces.IStorageManager;
import com.senla.storage.GarageStorage;
import com.senla.storage.MasterStorage;
import com.senla.storage.OrderStorage;
import com.senla.storage.SitStorage;

public class StorageManager implements IStorageManager {
	private GarageStorage garageStorage;
	private MasterStorage masterStorage;
	private OrderStorage orderStorage;
	private SitStorage sitStorage;

	@Override
	public GarageStorage getGarageStorage() {
		if (garageStorage == null) {
			garageStorage = new GarageStorage();
		}
		return garageStorage;
	}

	@Override
	public MasterStorage getMasterStorage() {
		if (masterStorage == null) {
			masterStorage = new MasterStorage();
		}
		return masterStorage;
	}

	@Override
	public OrderStorage getOrderStorage() {
		if (orderStorage == null) {
			orderStorage = new OrderStorage();
		}
		return orderStorage;
	}

	@Override
	public SitStorage getSitStorage() {
		if (sitStorage == null) {
			sitStorage = new SitStorage();
		}
		return sitStorage;
	}
}
