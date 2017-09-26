package service;

import service.intefraces.IMasterService;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;

public class MasterService implements IMasterService{
	private MasterStorage ms = ServiceStorage.getMasterStorage();
	private OrderStorage os = ServiceStorage.getOrderStorage();
}
