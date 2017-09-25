package service;

import java.util.ArrayList;
import java.util.List;

import entities.Master;
import entities.Order;
import sort.SortOrdersByAddedDate;
import sort.SortOrdersByEndingDate;
import sort.SortOrdersByPrice;
import sort.SortParameters;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;

public class OrderService {
	private OrderStorage os = ServiceStorage.getOrderStorage();
	private MasterStorage ms = ServiceStorage.getMasterStorage();

	public void showOrderExecutableByMaster(Master master) {
		for (int i = 0; i < ms.getMasters().size(); i++) {
			if (ms.getMasters().get(i).equals(master)) {
				System.out.println("order: " + ms.getMasters().get(i));
			}
		}
	}

	public void setOrderCancelled(long id) {
		for (int i = 0; i < os.getOrders().size(); i++) {
			if (os.getOrders().get(i).getId().equals(id)) {
				os.getOrders().get(i).setCancelled(true);
			}
		}
	}

	public void setOrderClosed(long id) {
		for (int i = 0; i < os.getOrders().size(); i++) {
			if (os.getOrders().get(i).getId().equals(id)) {
				os.getOrders().get(i).setClosed(true);
			}
		}
	}

	public void shiftOrderExecutionTime(int days) {
		for (int i = 0; i < os.getOrders().size(); i++) {
			os.getOrders().get(i).getAddedDate();
		}
	}

	public void sortOrders(String parameter) {
		switch (parameter) {
		case ("added date"): {
			os.sort(SortParameters.ADDED_DATE);
			break;
		}
		case ("ending date"): {
			os.sort(SortParameters.ENDING_DATE);
			break;
		}
		case ("price"): {
			os.sort(SortParameters.PRICE);
			break;
		}
		case ("start date"): {
			os.sort(SortParameters.START_WORKING_ON_DATE);
			break;
		}
		default:
			break;
		}
	}

	public void showExecutingOrders(String parameter) {
		List<Order> list = new ArrayList<Order>();
		for (int i = 0; i < os.getOrders().size(); i++) {
			if (os.getOrders().get(i).getStartWorkingOnDate().before(null)) {// TODO
																				// add
																				// current
																				// date
				list.add(os.getOrders().get(i));
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
