package service;

import java.util.ArrayList;
import java.util.List;

import entities.Master;
import entities.Order;
import service.intefraces.IOrderService;
import sort.SortOrdersByAddedDate;
import sort.SortOrdersByEndingDate;
import sort.SortOrdersByPrice;
import sort.SortParameters;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;

public class OrderService implements IOrderService {
	private OrderStorage os = ServiceStorage.getOrderStorage();
	private MasterStorage ms = ServiceStorage.getMasterStorage();

	public void setOrderCancelled(long id) {
		for (int i = 0; i < os.getAll().size(); i++) {
			if (os.getAll().get(i).getId().equals(id)) {
				os.getAll().get(i).setCancelled(true);
			}
		}
	}

	public void setOrderClosed(long id) {
		for (int i = 0; i < os.getAll().size(); i++) {
			if (os.getAll().get(i).getId().equals(id)) {
				os.getAll().get(i).setClosed(true);
			}
		}
	}

	public void shiftOrderExecutionTime(int days) {
		for (int i = 0; i < os.getAll().size(); i++) {
			os.getAll().get(i).getAddedDate();
		}
	}

	public void sortOrders(String parameter) {
		os.sort(os.getAll(), SortParameters.getValueOf(parameter));
	}

	public void showExecutingOrders(String parameter) {

	}
}
