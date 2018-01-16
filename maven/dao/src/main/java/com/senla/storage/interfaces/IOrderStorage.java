package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.util.SortParameters;

public interface IOrderStorage extends ISortableStorage<Order> {

	List<Order> getExecutingOrders(EntityManager manager, SortParameters parameter) throws SQLException;

	List<Order> getOrdersForPeriodOfTime(EntityManager manager, Date beforeDate, Date afterDate,
			SortParameters parameter) throws SQLException;

	void setOrderCancelled(EntityManager manager, Long id, Boolean value) throws SQLException;

	void setOrderClosed(EntityManager manager, Long id, Boolean value) throws SQLException;

	Date getNearestDate(EntityManager manager) throws SQLException;

	List<Master> getMastersExecutingConcreteOrder(EntityManager manager, Long id) throws SQLException;

	void shiftOrderExecutionTime(EntityManager manager, int days) throws SQLException;
}
