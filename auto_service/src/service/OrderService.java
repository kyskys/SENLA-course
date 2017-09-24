package service;

import entities.Master;
import entities.Order;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;

public class OrderService {
	private OrderStorage os = ServiceStorage.getOrderStorage();
	private MasterStorage ms = ServiceStorage.getMasterStorage();
	public void showOrderExecutableByMaster(Master master) {
		for(int i=0;i<ms.getMasters().size();i++) {
			if (ms.getMasters().get(i).equals(master)) {
				System.out.println("order: "+ms.getMasters().get(i));
			}
		}
	}
	public void setOrderCancelled(Order order) {
		
	}
}
