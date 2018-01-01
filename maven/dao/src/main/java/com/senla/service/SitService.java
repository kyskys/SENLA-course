package com.senla.service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import com.senla.entities.Garage;
import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.service.interfaces.ISitService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IGarageStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISitStorage;

import annotation.Injectable;

public class SitService extends AbstractService<Sit> implements ISitService {
	@Injectable
	private ISitStorage sitStorage;
	@Injectable
	private IOrderStorage orderStorage;
	@Injectable
	private IGarageStorage garageStorage;

	@Override
	public IAbstractStorage<Sit> getStorage() {
		return sitStorage;
	}

	@Override
	public List<Sit> getFreeSits() throws Throwable {
		return executeTransactionAction(manager -> {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Sit> query = builder.createQuery(Sit.class);
			Root<Sit> root = query.from(Sit.class);
			Subquery<Order> subQuery = query.subquery(Order.class);
			Root<Order> subRoot = subQuery.from(Order.class);
			query.select(root).where(root.get("order").in(subQuery.select(subRoot)
					.where(builder.lessThan(root.get("ending_date"), Date.valueOf(LocalDate.now())))));
			TypedQuery<Sit> sits = manager.createQuery(query);
			return sits.getResultList();
		});
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) throws Throwable {
		return executeTransactionAction(manager -> {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Sit> query = builder.createQuery(Sit.class);
			Root<Sit> root = query.from(Sit.class);
			Subquery<Order> subQuery = query.subquery(Order.class);
			Root<Order> subRoot = subQuery.from(Order.class);
			query.select(root).where(root.get("order")
					.in(subQuery.select(subRoot).where(builder.lessThan(root.get("ending_date"), date))));
			TypedQuery<Sit> sits = manager.createQuery(query);
			return sits.getResultList();
		});
	}

	@Override
	public synchronized void addOrderToSit(Long idOrder, Long idSit) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			Order order = orderStorage.get(manager, idOrder);
			Sit sit = sitStorage.get(manager, idSit);
			order.setSit(sit);
			sit.setOrder(order);
			sitStorage.update(manager, sit);
			orderStorage.update(manager, order);
		});
	}

	@Override
	public synchronized void removeOrderFromSit(Long idSit) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			Sit sit = sitStorage.get(manager, idSit);
			Order order = sit.getOrder();
			order.setSit(null);
			sit.setOrder(null);
			sitStorage.update(manager, sit);
			orderStorage.update(manager, order);
		});
	}

	@Override
	public synchronized void addGarageToSit(Long idGarage, Long idSit) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			Garage garage = garageStorage.get(manager, idGarage);
			Sit sit = sitStorage.get(manager, idSit);
			garage.addSit(sit);
			sit.setGarage(garage);
			sitStorage.update(manager, sit);
			garageStorage.update(manager, garage);
		});
	}

	@Override
	public synchronized void removeGarageFromSit(Long idGarage, Long idSit) throws Throwable {
		executeSimpleTransactionAction(manager -> {
			Garage garage = garageStorage.get(manager, idGarage);
			Sit sit = sitStorage.get(manager, idSit);
			garage.removeSit(sit);
			sit.setGarage(null);
			sitStorage.update(manager, sit);
			garageStorage.update(manager, garage);
		});
	}
}
