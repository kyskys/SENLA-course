package service;

import counter.Counter;
import entities.Order;
import service.intefraces.IOrderService;
import sort.SortParameters;
import storage.OrderStorage;
import storage.interfaces.ISortableStorage;

public class OrderService extends SortableService<Order> implements IOrderService {
	private OrderStorage orderStorage = Counter.getOrderStorage();

	@Override
	public ISortableStorage<Order> getStorage() {
		return orderStorage;
	}

	public void setOrderCancelled(long id) {
		orderStorage.setOrderCancelled(id);
	}

	public void setOrderClosed(long id) {
		orderStorage.setOrderClosed(id);
	}

	public void shiftOrderExecutionTime(int days) {
		for (int i = 0; i < orderStorage.getAll().size(); i++) {
			orderStorage.getAll().get(i).getAddedDate();
		}
	}

	public void showOrders(String parameter) {
		orderStorage.getAll(SortParameters.getValueOf(parameter));
	}

	public void showExecutingOrders(String parameter) {
		orderStorage.getAll(SortParameters.getValueOf(parameter));
	}

}
