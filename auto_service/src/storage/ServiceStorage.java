package storage;

public class ServiceStorage {
	private static GarageStorage garageStorage;
	private static MasterStorage masterStorage;
	private static OrderStorage orderStorage;
	private static SitStorage sitStorage;
	static {
		garageStorage = new GarageStorage();
		masterStorage = new MasterStorage();
		orderStorage = new OrderStorage();
		sitStorage = new SitStorage();
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
