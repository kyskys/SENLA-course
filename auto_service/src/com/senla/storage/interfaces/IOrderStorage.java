package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Order;
import com.senla.sort.SortParameters;

public interface IOrderStorage extends ISortableStorage<Order> {
	
	List<Order> getExecutingOrders(SortParameters parameter) throws SQLException;

	List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter) throws SQLException;

	void setOrderCancelled(Long id, Boolean value) throws SQLException;

	void setOrderClosed(Long id, Boolean value) throws SQLException;

	Date getNearestDate() throws SQLException;
	
	void shiftOrderExecutionTime(int days) throws SQLException;
}
