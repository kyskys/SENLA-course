package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.senla.entities.Order;
import com.senla.util.SortParameters;

public interface IOrderStorage extends ISortableStorage<Order> {
	
	List<Order> getExecutingOrders(Session session, SortParameters parameter) throws SQLException;

	List<Order> getOrdersForPeriodOfTime(Session session, Date beforeDate, Date afterDate, SortParameters parameter) throws SQLException;

	void setOrderCancelled(Session session, Long id, Boolean value) throws SQLException;

	void setOrderClosed(Session session, Long id, Boolean value) throws SQLException;

	Date getNearestDate(Session session) throws SQLException;
}
