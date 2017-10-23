package com.senla.manager.interfaces;

import com.senla.service.*;

public interface IServiceManager {
	GarageService getGarageService();
	MasterService getMasterService();
	OrderService getOrderService();
	SitService getSitService();
}
