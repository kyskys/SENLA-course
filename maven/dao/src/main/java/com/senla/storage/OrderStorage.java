package com.senla.storage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.senla.entities.Order;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.IOrderStorage;

public class OrderStorage extends SortableStorage<Order> implements IOrderStorage {

	@Override
	public Class<Order> getGenericClass() {
		return Order.class;
	}

	@Override
	public String convertToFieldName(SortParameters parameter) throws SQLException {

		switch (parameter) {
		case ADDED_DATE: {
			return "added_date";
		}
		case ENDING_DATE: {
			return "ending_date";
		}
		case PRICE: {
			return "price";
		}
		case START_WORKING_ON_DATE: {
			return "start_date";
		}
		default:
			return "order_id";
		}

	}

	@Override
	public List<Order> getExecutingOrders(Session session, SortParameters parameter) throws SQLException {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		query.select(root)
				.where(builder.and(
						builder.and(
								builder.lessThan(root.get("ending_date"), Date.valueOf(LocalDate.now())),
								builder.notEqual(root.get("cancelled"), 1), 
								builder.notEqual(root.get("closed"), 1))));
		Query<Order> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Session session, Date beforeDate, Date afterDate,
			SortParameters parameter) throws SQLException {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		query.select(root)
				.where(builder.and(
						builder.lessThan(root.get("start_date"), beforeDate),
						builder.greaterThan(root.get("ending_date"), afterDate)))
				.orderBy(builder.asc(root.get(convertToFieldName(parameter))));
		Query<Order> result = session.createQuery(query);
		return result.getResultList();
	}

	@Override
	public void setOrderCancelled(Session session, Long id, Boolean value) throws SQLException {
		Order order = session.get(Order.class, id);
		order.setCancelled(value);
		session.update(order);
	}

	@Override
	public void setOrderClosed(Session session, Long id, Boolean value) throws SQLException {
		Order order = session.get(Order.class, id);
		order.setClosed(value);
		session.update(order);
	}

	@Override
	public Date getNearestDate(Session session) throws SQLException {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Date> query = builder.createQuery(Date.class);
		Root<Order> root = query.from(Order.class);
		query.select(builder.least
				(root.get("ending_date")))
			 		.where(builder.and(
			 				builder.notEqual(root.get("cancelled"), 1), 
			 				builder.notEqual(root.get("closed"), 1))
				);
		Query<Date> result = session.createQuery(query);
		return result.getSingleResult();
	}

}
