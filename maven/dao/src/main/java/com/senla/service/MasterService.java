package com.senla.service;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.service.interfaces.*;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISortableStorage;

import annotation.Injectable;

public class MasterService extends SortableService<Master> implements IMasterService {
	@Injectable
	private IMasterStorage masterStorage;
	@Injectable
	private IOrderStorage orderStorage;

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) throws Throwable {
		return executeTransactionAction(manager -> {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Order> query = builder.createQuery(Order.class);
			Root<Order> root = query.from(Order.class);
			Subquery<Long> subQuery = query.subquery(Long.class);
			Root<Master> subRoot = subQuery.from(Master.class);
			query.select(root).where(builder.equal(root.get("id"),
					subQuery.select(subRoot.get("order")).where(builder.equal(subRoot.get("id"), id))));
			TypedQuery<Order> result = manager.createQuery(query);
			return result.getSingleResult();
		});
	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) throws Throwable {
		return (List<Master>) executeTransactionAction(manager -> {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Master> query = builder.createQuery(Master.class);
			Root<Master> root = query.from(Master.class);
			Subquery<Order> subQuery = query.subquery(Order.class);
			Root<Order> subRoot = subQuery.from(Order.class);
			query.select(root).where(root.get("order")
					.in(subQuery.select(subRoot).where(builder.equal(subRoot.get("endingDate"), date))));
			TypedQuery<Master> result = manager.createQuery(query);
			return result.getResultList();
		});

	}

	@Override
	public synchronized void addOrderToMaster(Long idOrder, Long idMaster) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			Master master = masterStorage.get(manager, idMaster);
			Order order = orderStorage.get(manager, idOrder);
			master.setOrder(order);
			order.addMaster(master);
			masterStorage.update(manager, master);
			orderStorage.update(manager, order);
		});
	}

	@Override
	public synchronized void removeOrderFromMaster(Long idMaster) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			Master master = masterStorage.get(manager, idMaster);
			Order order = master.getOrder();
			master.setOrder(null);
			order.removeMaster(master);
			masterStorage.update(manager, master);
			orderStorage.update(manager, order);
		});
	}

}
