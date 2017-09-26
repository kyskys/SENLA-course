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

public class OrderService implements IOrderService{
	private OrderStorage os = ServiceStorage.getOrderStorage();
	private MasterStorage ms = ServiceStorage.getMasterStorage();

	public void showOrderExecutableByMaster(Master master) {
		for (int i = 0; i < ms.getList().size(); i++) {
			if (ms.getList().get(i).equals(master)) {
				System.out.println("order: " + ms.getList().get(i));
			}
		}
	}

	public void setOrderCancelled(long id) {
		for (int i = 0; i < os.getList().size(); i++) {
			if (os.getList().get(i).getId().equals(id)) {
				os.getList().get(i).setCancelled(true);
			}
		}
	}

	public void setOrderClosed(long id) {
		for (int i = 0; i < os.getList().size(); i++) {
			if (os.getList().get(i).getId().equals(id)) {
				os.getList().get(i).setClosed(true);
			}
		}
	}

	public void shiftOrderExecutionTime(int days) {
		for (int i = 0; i < os.getList().size(); i++) {
			os.getList().get(i).getAddedDate();
		}
	}

	public void sortOrders(String parameter) {
		os.sort(os.getList(), SortParameters.getValueOf(parameter));
	}

	public void showExecutingOrders(String parameter) {
		List<Order> list = new ArrayList<Order>();
		for (int i = 0; i < os.getList().size(); i++) {
			if (os.getList().get(i).getStartWorkingOnDate().before(null)) {// TODO
																				// add
																				// current
																				// date
				list.add(os.getList().get(i));
			}
		}
		switch (parameter) {
		case ("added date"): {
			list.sort(new SortOrdersByAddedDate());
			break;
		}
		case ("ending date"): {
			list.sort(new SortOrdersByEndingDate());
			break;
		}
		case ("price"): {
			list.sort(new SortOrdersByPrice());
			break;
		}
		default: {
			break;
		}
		}
	}

}
