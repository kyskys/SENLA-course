package com.senla.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Order;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.IOrderStorage;

public class OrderStorage extends SortableStorage<Order> implements IOrderStorage {

	@Override
	public Class<Order> getGenericClass() {
		return Order.class;
	}
	
	@Override
	protected String sort(SortParameters parameter) throws SQLException {

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
	public List<Order> getExecutingOrders(SortParameters parameter) throws SQLException {
		List<Order> result = new ArrayList<Order>();
		try (PreparedStatement statement = getConnection()
				.prepareStatement(String.format("%s order by %s", GET_EXECUTING_ORDERS, sort(parameter)))) {
			statement.setDate(0, Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getLong("order_id"));
				order.setAddedDate(rs.getDate("added_date"));
				order.setStartWorkingOnDate(rs.getDate("start_date"));
				order.setEndingDate(rs.getDate("ending_date"));
				order.setClosed(rs.getBoolean("closed"));
				order.setCancelled(rs.getBoolean("cancelled"));
				order.setPrice(rs.getDouble("price"));
				result.add(order);
			}
			return result;
		}
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter)
			throws SQLException {
		List<Order> result = new ArrayList<Order>();
		try (PreparedStatement statement = getConnection()
				.prepareStatement(String.format("%s order by %s", GET_ORDERS_FOR_PERIOD_OF_TIME, sort(parameter)))) {
			statement.setDate(0, beforeDate);
			statement.setDate(1, afterDate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getLong("order_id"));
				order.setAddedDate(rs.getDate("added_date"));
				order.setStartWorkingOnDate(rs.getDate("start_date"));
				order.setEndingDate(rs.getDate("ending_date"));
				order.setClosed(rs.getBoolean("closed"));
				order.setCancelled(rs.getBoolean("cancelled"));
				order.setPrice(rs.getDouble("price"));
				result.add(order);
			}
			return result;
		}
	}

	@Override
	public void setOrderCancelled(Long id, Boolean value) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(SET_ORDER_CANCELLED)) {
			statement.setBoolean(0, value);
			statement.setLong(1, id);
			statement.executeQuery();
		}
	}

	@Override
	public void setOrderClosed(Long id, Boolean value) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(SET_ORDER_CLOSED)) {
			statement.setBoolean(0, value);
			statement.setLong(1, id);
			statement.executeQuery();
		}
	}

	@Override
	public Date getNearestDate() throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_NEAREST_DATE)) {
			ResultSet rs = statement.executeQuery();
			return rs.getDate(0);
		}
	}

}
