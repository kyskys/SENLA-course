package com.senla.service;

import java.util.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.service.intefraces.IOrderService;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISortableStorage;

import dependency.DependencyManager;

public class OrderService extends SortableService<Order> implements IOrderService {
	private IOrderStorage orderStorage = DependencyManager.getInstance(IOrderStorage.class);
	private IMasterStorage masterStorage = DependencyManager.getInstance(IMasterStorage.class);

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

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) {
		Master master = masterStorage.get(idMaster);
		Order order = orderStorage.get(idOrder);
		master.setOrder(order);
		order.addMaster(master);
	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) {
		Master master = masterStorage.get(idMaster);
		Order order = orderStorage.get(idOrder);
		master.setOrder(null);
		order.removeMaster(master);
	}

}
