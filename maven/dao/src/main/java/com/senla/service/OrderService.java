package com.senla.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.entities.Sit;
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
	public void setOrderCancelled(Long id, Boolean value) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			orderStorage.setOrderCancelled(manager, id, value);
		});
	}

	@Override
	public void setOrderClosed(Long id, Boolean value) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			orderStorage.setOrderClosed(manager, id, value);
		});
	}

	@Override
	public void shiftOrderExecutionTime(int days) throws Throwable {//TODO
		executeSimpleTransactionAction(manager -> {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaUpdate<Order> query = builder.createCriteriaUpdate(Order.class);
			Root<Order> root = query.from(Order.class);
			TypedQuery<Sit> sits = manager.createQuery(query);
		});
	}

	@Override
	public List<Order> getExecutingOrders(SortParameters parameter) throws Throwable {
		return executeTransactionAction(manger -> {
			return orderStorage.getExecutingOrders(manger, parameter);
		});
	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(Long id) throws Throwable {
		return executeTransactionAction(manager -> {
			Order order = orderStorage.get(manager, id);
			return order.getMasters();
		});
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter)
			throws Throwable {
		return executeTransactionAction(manager -> {
			return orderStorage.getOrdersForPeriodOfTime(manager, beforeDate, afterDate, parameter);
		});
	}

	@Override
	public Date getNearestDate() throws Throwable {
		return executeTransactionAction(manager -> {
			return orderStorage.getNearestDate(manager);
		});
	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) throws Throwable {
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
	public void removeMasterFromOrder(Long idMaster, Long idOrder) throws Throwable {
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
