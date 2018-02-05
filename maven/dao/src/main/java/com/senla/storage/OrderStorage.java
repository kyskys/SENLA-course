package com.senla.storage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.stereotype.Service;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.IOrderStorage;


@Service
public class OrderStorage extends SortableStorage<Order> implements IOrderStorage {

	@Override
	public Class<Order> getGenericClass() {
		return Order.class;
	}

	@Override
	public List<Order> getExecutingOrders(EntityManager manager, SortParameters parameter) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		root.fetch("masters");
		Predicate lessThanDate = builder.lessThan(root.get("endingDate"), Date.valueOf(LocalDate.now()));
		Predicate notCancelled = builder.notEqual(root.get("cancelled"), 1);
		Predicate notClosed = builder.notEqual(root.get("closed"), 1);
		query.select(root).where(builder.and(lessThanDate, notCancelled, notClosed));
		TypedQuery<Order> result = manager.createQuery(query);
		return result.getResultList();
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(EntityManager manager, Date beforeDate, Date afterDate,
			SortParameters parameter) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		root.fetch("masters");
		query.select(root)
				.where(builder.and(builder.lessThan(root.get("startWorkingOnDate"), beforeDate),
						builder.greaterThan(root.get("endingDate"), afterDate)))
				.orderBy(builder.asc(root.get(convertToFieldName(parameter))));
		TypedQuery<Order> result = manager.createQuery(query);
		return result.getResultList();
	}

	@Override
	public void setOrderCancelled(EntityManager manager, Long id, Boolean value) throws SQLException {
		Order order = manager.find(Order.class, id);
		order.setCancelled(value);
		this.update(manager, order);
	}

	@Override
	public void setOrderClosed(EntityManager manager, Long id, Boolean value) throws SQLException {
		Order order = manager.find(Order.class, id);
		order.setClosed(value);
		this.update(manager, order);
	}

	@Override
	public Date getNearestDate(EntityManager manager) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Date> query = builder.createQuery(Date.class);
		Root<Order> root = query.from(Order.class);
		root.fetch("masters");
		query.select(builder.least(root.get("endingDate"))).where(
				builder.and(builder.notEqual(root.get("cancelled"), 1), builder.notEqual(root.get("closed"), 1)));
		TypedQuery<Date> result = manager.createQuery(query);
		return result.getSingleResult();
	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(EntityManager manager, Long id) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Master> query = builder.createQuery(Master.class);
		Root<Master> root = query.from(Master.class);
		Subquery<Order> subQuery = query.subquery(Order.class);
		Root<Order> subRoot = subQuery.from(Order.class);
		subRoot.fetch("masters");
		query.select(root).where(
				builder.equal(root.get("order"), subQuery.select(subRoot).where(builder.equal(subRoot.get("id"), id))));
		TypedQuery<Master> result = manager.createQuery(query);
		return result.getResultList();
	}

	@Override
	public void shiftOrderExecutionTime(EntityManager manager, int days) throws SQLException {
		StoredProcedureQuery query = manager.createStoredProcedureQuery("shift_order_execution_time");
		query.registerStoredProcedureParameter("days", Integer.class, ParameterMode.IN);
		query.setParameter("days", days);
		query.execute();
	}

	@Override
	protected void joinLazyFields(Root<?> root) {
		root.fetch("masters");
	}
}
