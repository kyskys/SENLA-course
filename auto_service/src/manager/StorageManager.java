package manager;

import java.util.List;

import entities.BaseEntity;
import storage.GarageStorage;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.SitStorage;

public class StorageManager {
	private static GarageStorage garageStorage;// = new GarageStorage();
	private static MasterStorage masterStorage;// = new MasterStorage();
	private static OrderStorage orderStorage;// = new OrderStorage();
	private static SitStorage sitStorage;// = new SitStorage();
	private static long id = 0;

	static {
		garageStorage = new GarageStorage();
		masterStorage = new MasterStorage();
		orderStorage = new OrderStorage();
		sitStorage = new SitStorage();
	}

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

	public static GarageStorage getGarageStorage() {
		return garageStorage;
	}

	public static MasterStorage getMasterStorage() {
		return masterStorage;
	}

	public static OrderStorage getOrderStorage() {
		return orderStorage;
	}

	public static SitStorage getSitStorage() {
		return sitStorage;
	}

}
