package com.senla.service;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.service.interfaces.IOrderService;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISortableStorage;

import annotation.Injectable;

public class OrderService extends SortableService<Order> implements IOrderService {
	@Injectable
	private IOrderStorage orderStorage;
	@Injectable
	private IMasterStorage masterStorage;

	@Override
	public ISortableStorage<Order> getStorage() {
		return orderStorage;
	}

	@Override
	public void setOrderCancelled(Long id, Boolean value) {
		executeSimpleTransactionAction(manager -> {
			orderStorage.setOrderCancelled(manager, id, value);
		});
	}

	@Override
	public void setOrderClosed(Long id, Boolean value) {
		executeSimpleTransactionAction(manager -> {
			orderStorage.setOrderClosed(manager, id, value);
		});
	}

	@Override
	public void shiftOrderExecutionTime(int days) {
		executeSimpleTransactionAction(manager -> {
			orderStorage.shiftOrderExecutionTime(manager, days);
		});

	}

	@Override
	public List<Order> getExecutingOrders(SortParameters parameter) {
		return executeAction(manger -> {
			return orderStorage.getExecutingOrders(manger, parameter);
		});
	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(Long id) {
		return executeAction(manager -> {
			return orderStorage.getMastersExecutingConcreteOrder(manager, id);
		});
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter) {
		return executeAction(manager -> {
			return orderStorage.getOrdersForPeriodOfTime(manager, beforeDate, afterDate, parameter);
		});
	}

	@Override
	public Date getNearestDate() {
		return executeAction(manager -> {
			return orderStorage.getNearestDate(manager);
		});
	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) {
		executeSimpleTransactionAction(manager -> {
			Master master = masterStorage.get(manager, idMaster);
			Order order = orderStorage.get(manager, idOrder);
			master.setOrder(order);
			order.addMaster(master);
			orderStorage.update(manager, order);
			masterStorage.update(manager, master);
		});
	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) {
		executeSimpleTransactionAction(manager -> {
			Master master = masterStorage.get(manager, idMaster);
			Order order = orderStorage.get(manager, idOrder);
			master.setOrder(null);
			order.removeMaster(master);
			orderStorage.update(manager, order);
			masterStorage.update(manager, master);
		});
	}

}
