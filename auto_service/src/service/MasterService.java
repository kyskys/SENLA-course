package service;

import java.util.List;

import entities.Order;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;
import sort.SortParameters;
import sort.Sortable;

public class MasterService extends Sortable {
	private MasterStorage ms = ServiceStorage.getMasterStorage();
	private OrderStorage os = ServiceStorage.getOrderStorage();

	public void showMastersExecutingOrder(Order order) {
		for (int i = 0; i < os.getList().size(); i++) {
			if (os.getList().get(i).equals(order)) {
				for (int j = 0; j < os.getList().get(i).getMasters().size(); j++) {
					System.out.println("master: " + os.getList().get(i).getMasters().get(j));
				}
			}
		}
	}

	public void showMasters(String parameter) {
		switch (parameter) {
		case ("busy"): {
			sort(ms.getList(),SortParameters.BUSY);
		}

		case ("alphabet"): {
			sort(ms.getList(),SortParameters.ALPHABET);
		}
		default: {
			break;
		}
		}

	}
}
