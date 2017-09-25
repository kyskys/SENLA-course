package service;

import java.util.List;

import entities.Order;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;
import sort.SortParameters;
import sort.Sortable;

public class MasterService extends Sortable{
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
			sort(ms.getMasters(),SortParameters.BUSY);
		}

		}
		case ("alphabet"): {
			sort(ms.getMasters(),SortParameters.ALPHABET);
		}
		default: {
			break;
		}
		}
	}

	@Override
	protected static boolean sort(List<Master> list, SortParameters sp) {
		switch (sp) {
		case (BUSY): {
			list.sort(new SortMastersByBusy());

		}
		case (ALPHABET): {
			list.sort(new SortMastersByBusy());
		}
		default: {
			break;
		}
		return false;
	}
}
