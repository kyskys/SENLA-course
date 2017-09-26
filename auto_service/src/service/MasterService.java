package service;

import java.util.List;

import entities.Order;
import service.intefraces.IMasterService;
import storage.MasterStorage;
import storage.OrderStorage;
import storage.ServiceStorage;
import sort.SortParameters;

public class MasterService implements IMasterService{
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
		ms.sort(ms.getList(), SortParameters.getValueOf(parameter));
	}
}
