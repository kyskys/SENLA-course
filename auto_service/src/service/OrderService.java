package service;

import java.util.Date;

import entities.Order;
import manager.StorageManager;
import service.intefraces.IOrderService;
import sort.SortParameters;
import storage.OrderStorage;
import storage.interfaces.IMasterStorage;
import storage.interfaces.ISortableStorage;
import util.Utils;

public class OrderService extends SortableService<Order> implements IOrderService {
	private OrderStorage orderStorage = StorageManager.getOrderStorage();
	private IMasterStorage masterStorage = StorageManager.getMasterStorage();

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
	public String showOrders(String parameter) {
		return Utils.getListAsString(orderStorage.getAll(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String showExecutingOrders(String parameter) {
		return Utils.getListAsString(orderStorage.getAll(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String showMastersExecutingConcreteOrder(Long id) {
		return Utils.getListAsString(orderStorage.getMastersExecutingConcreteOrder(id));
	}

	@Override
	public String showOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter) {
		return Utils.getListAsString(
				orderStorage.getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter)));
	}

	@Override
	public String showNearestDate() {
		return orderStorage.showNearestDate().toString();
	}

}
