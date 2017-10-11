package manager;

import manager.interfaces.IServiceManager;
import manager.interfaces.IStorageManager;
import service.*;

public class ServiceManager implements IServiceManager {
	private IStorageManager storageManager;
	private GarageService garageService;
	private MasterService masterService;
	private OrderService orderService;
	private SitService sitService;

	public ServiceManager(IStorageManager storageManager) {
		this.storageManager = storageManager;
	}

	@Override
	public GarageService getGarageService() {
		if (garageService == null) {
			garageService = new GarageService(storageManager.getGarageStorage(), storageManager.getSitStorage());
		}
		return garageService;
	}

	@Override
	public MasterService getMasterService() {
		if (masterService == null) {
			masterService = new MasterService(storageManager.getMasterStorage(), storageManager.getOrderStorage());
		}
		return masterService;
	}

	@Override
	public OrderService getOrderService() {
		if (orderService == null) {
			orderService = new OrderService(storageManager.getMasterStorage(), storageManager.getOrderStorage());
		}
		return orderService;
	}

	@Override
	public SitService getSitService() {
		if (sitService == null) {
			sitService = new SitService(storageManager.getSitStorage(), storageManager.getOrderStorage());
		}
		return sitService;
	}

}
