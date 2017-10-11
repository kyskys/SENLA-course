package manager.interfaces;

import service.*;

public interface IServiceManager {
	GarageService getGarageService();
	MasterService getMasterService();
	OrderService getOrderService();
	SitService getSitService();
}
