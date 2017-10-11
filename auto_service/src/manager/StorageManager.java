package manager;

import java.util.List;

import entities.BaseEntity;
import manager.interfaces.IStorageManager;
import storage.GarageStorage;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.SitStorage;

public class StorageManager implements IStorageManager {
	private GarageStorage garageStorage;
	private MasterStorage masterStorage;
	private OrderStorage orderStorage;
	private SitStorage sitStorage;
	private static long id = 0;

	public static long getId() {
		return ++id;
	}

	@SafeVarargs
	public static void recountId(List<? extends BaseEntity>... lists) {
		for (List<? extends BaseEntity> x : lists) {
			for (BaseEntity y : x) {
				if (y.getId() > id) {
					id = y.getId();
				}
			}
		}
	}

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
