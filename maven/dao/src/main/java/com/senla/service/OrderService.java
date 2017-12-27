package com.senla.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
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

	private static final String SHIFT_ORDER_EXECUTION_TIME_QUERY = "set sql_safe_updates = 0; update auto_service_db.order set ending_date = adddate(ending_date, interval ? day);";
	private static final String GET_MASTERS_EXECUTING_CONCRETE_ORDER_QUERY = "select * from auto_service_db.master where order_id = ?";
	private static final String REMOVE_MASTER_FROM_ORDER_QUERY = "update auto_service_db.master set (order_id) values(null) where order_id=?";

	@Override
	public ISortableStorage<Order> getStorage() {
		return orderStorage;
	}

	@Override
	public void setOrderCancelled(Long id, Boolean value) throws SQLException {
		orderStorage.setOrderCancelled(id, value);
	}

	@Override
	public void setOrderClosed(Long id, Boolean value) throws SQLException {
		orderStorage.setOrderClosed(id, value);
	}

	@Override
	public void shiftOrderExecutionTime(int days) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(SHIFT_ORDER_EXECUTION_TIME_QUERY)) {
			getConnection().setAutoCommit(false);
			statement.setInt(0, days);
			statement.executeUpdate();
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}

	}

	@Override
	public List<Order> getExecutingOrders(SortParameters parameter) throws SQLException {
		return orderStorage.getExecutingOrders(parameter);
	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(Long id) throws SQLException {
		List<Master> result = new ArrayList<Master>();
		try (PreparedStatement statement = getConnection()
				.prepareStatement(GET_MASTERS_EXECUTING_CONCRETE_ORDER_QUERY)) {
			statement.setLong(0, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Master master = new Master(null);
				master.setId(rs.getLong("master_id"));
				master.setBusy(rs.getBoolean("busy"));
				master.setName(rs.getString("name"));
				master.setOrder(orderStorage.get(id));
				result.add(master);
			}
			return result;
		}

	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter)
			throws SQLException {
		return orderStorage.getOrdersForPeriodOfTime(beforeDate, afterDate, parameter);
	}

	@Override
	public Date getNearestDate() throws SQLException {
		return orderStorage.getNearestDate();
	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) throws SQLException {
		try {
			Master master = masterStorage.get(idMaster);
			Order order = orderStorage.get(idOrder);
			master.setOrder(order);
			order.addMaster(master);
			getStorage().update(order);
			masterStorage.update(master);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(REMOVE_MASTER_FROM_ORDER_QUERY)) {
			statement.setLong(0, idMaster);
			statement.executeUpdate();
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public void create(Order entity) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			getStorage().create(entity);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public void delete(Long id) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			getStorage().delete(id);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public void update(Order entity) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			getStorage().update(entity);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public Order get(Long id) throws SQLException {
		Order order = getStorage().get(id);
		order.setMasters(getMastersExecutingConcreteOrder(id));
		return order;
	}

	@Override
	public List<Order> getAll() throws SQLException {
		List<Order> result = getStorage().getAll(null);
		for (Order order : result) {
			order.setMasters(getMastersExecutingConcreteOrder(order.getId()));
		}
		return result;
	}

}
