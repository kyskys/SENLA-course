package service;

import entities.Order;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;
import sort.SortParameters;

public class MasterService {
	private MasterStorage ms = ServiceStorage.getMasterStorage();
	private OrderStorage os = ServiceStorage.getOrderStorage();

	public void showMastersExecutingOrder(Order order) {
		for (int i = 0; i < os.getOrders().size(); i++) {
			if (os.getOrders().get(i).equals(order)) {
				for (int j = 0; j < os.getOrders().get(i).getMasters().size(); j++) {
					System.out.println("master: " + os.getOrders().get(i).getMasters().get(j));
				}
			}
		}
	}

	public void showMasters(String parameter) {
		switch (parameter) {
		case ("busy"): {
			os.sort(SortParameters.BUSY);

		}
		case ("alphabet"): {
			os.sort(SortParameters.ALPHABET);
		}
		default: {
			break;
		}
		}
	}
}
