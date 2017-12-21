package com.senla.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Order;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.IOrderStorage;

public class OrderStorage extends SortableStorage<Order> implements IOrderStorage {

	private static final String CREATE_QUERY = "insert into auto_service_db.order(order_id,added_date,start_date,ending_date,closed,cancelled,price) values(?,?,?,?,?,?,?)";
	private static final String DELETE_QUERY = "delete from auto_service_db.order where order_id = ?";
	private static final String UPDATE_QUERY = "update auto_service_db.order set order_id = ? added_date = ? start_date = ? ending_date = ? closed = ? cancelled = ? price = ? where order_id = ?";
	private static final String GET_ONE_QUERY = "select * from auto_service_db.order where order_id = ?";
	private static final String GET_ALL_QUERY = "select * from auto_service_db.order";
	private static final String SET_ORDER_CLOSED = "update auto_service_db.order set closed = ? where order_id = ?";
	private static final String SET_ORDER_CANCELLED = "update auto_service_db.order set cancelled = ? where order_id = ?";
	private static final String GET_EXECUTING_ORDERS = "select * from auto_service_db.order where start_date < ?";
	private static final String GET_ORDERS_FOR_PERIOD_OF_TIME = " select * from auto_service_db.order where start_date < ? and ending_date > ?";
	private static final String GET_NEAREST_DATE = "select min(ending_date) from auto_service_db.order where cancelled!=1 and closed!=1";

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

	@Override
	public void create(Order entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
			statement.setLong(0, entity.getId());
			statement.setDate(1, entity.getAddedDate());
			statement.setDate(2, entity.getStartWorkingOnDate());
			statement.setDate(3, entity.getEndingDate());
			statement.setBoolean(4, entity.isClosed());
			statement.setBoolean(5, entity.isCancelled());
			statement.setDouble(6, entity.getPrice());
			statement.executeQuery();
		}
	}

	@Override
	public void delete(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(DELETE_QUERY)) {
			statement.setLong(0, id);
			statement.executeQuery();
		}
	}

	@Override
	public void update(Order entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
			statement.setLong(0, entity.getId());
			statement.setDate(1, entity.getAddedDate());
			statement.setDate(2, entity.getStartWorkingOnDate());
			statement.setDate(3, entity.getEndingDate());
			statement.setBoolean(4, entity.isClosed());
			statement.setBoolean(5, entity.isCancelled());
			statement.setDouble(6, entity.getPrice());
			statement.executeQuery();
		}
	}

	@Override
	public Order get(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
			ResultSet rs = statement.executeQuery();
			Order order = new Order();
			order.setId(rs.getLong("order_id"));
			order.setAddedDate(rs.getDate("added_date"));
			order.setStartWorkingOnDate(rs.getDate("start_date"));
			order.setEndingDate(rs.getDate("ending_date"));
			order.setClosed(rs.getBoolean("closed"));
			order.setCancelled(rs.getBoolean("cancelled"));
			order.setPrice(rs.getDouble("price"));
			return order;
		}
	}

	@Override
	public List<Order> getAll() throws SQLException {
		return getAll(null);
	}

	@Override
	public List<Order> getAll(SortParameters parameter) throws SQLException {
		List<Order> result = new ArrayList<Order>();
		try (PreparedStatement statement = getConnection()
				.prepareStatement(String.format("%s order by %s", GET_ALL_QUERY, sort(parameter)))) {
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

}
