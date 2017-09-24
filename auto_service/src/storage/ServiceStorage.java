package storage;

public class ServiceStorage {
	private static GarageStorage garageStorage = new GarageStorage();
	private static MasterStorage masterStorage = new MasterStorage();
	private static OrderStorage orderStorage = new OrderStorage();
	private static SitStorage sitStorage = new SitStorage();

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
