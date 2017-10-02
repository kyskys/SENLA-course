package service;

import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Order;
import manager.StorageManager;
import service.intefraces.IOrderService;
import sort.SortParameters;
import storage.OrderStorage;
import storage.interfaces.ISortableStorage;

public class OrderService extends SortableService<Order> implements IOrderService {
	private OrderStorage orderStorage = StorageManager.getOrderStorage();

	@Override
	public ISortableStorage<Order> getStorage() {
		return orderStorage;
	}

	@Override
	public void setOrderCancelled(Long id) {
		orderStorage.setOrderCancelled(id);
	}

	@Override
	public void setOrderClosed(Long id) {
		orderStorage.setOrderClosed(id);
	}

	@Override
	public void shiftOrderExecutionTime(int days) {
		for (int i = 0; i < orderStorage.getAll().size(); i++) {
			Date endingDate = orderStorage.getAll().get(i).getEndingDate();
			endingDate.setTime(endingDate.getTime() + days * 86400000);
		}
	}

	@Override
	public List<Order> getExecutingOrders(SortParameters parameter) {
		return orderStorage.getAll(parameter);
	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(Long id) {
		return orderStorage.getMastersExecutingConcreteOrder(id);
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter) {
		return orderStorage.getOrdersForPeriodOfTime(beforeDate, afterDate, parameter);
	}

	@Override
	public Date getNearestDate() {
		return orderStorage.showNearestDate();
	}

}
