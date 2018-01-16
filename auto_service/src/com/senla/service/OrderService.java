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
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISortableStorage;

import annotation.Injectable;

public class OrderService extends SortableService<Order> implements IOrderService {
	@Injectable
	private IOrderStorage orderStorage;
	@Injectable
	private IMasterStorage masterStorage;

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
		try {
			getConnection().setAutoCommit(false);
			orderStorage.shiftOrderExecutionTime(days);
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
		return masterStorage.getMastersExecutingConcreteOrder(id);
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
		try {
			Master master = masterStorage.get(idMaster);
			Order order = orderStorage.get(idOrder);
			order.removeMaster(master);
			master.setOrder(null);
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

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) throws SQLException {
		return orderStorage.get(masterStorage.getMasterIdByOrderId(id));
	}

}
