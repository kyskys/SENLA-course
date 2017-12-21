package com.senla.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.service.interfaces.IMasterService;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISortableStorage;

import annotation.Injectable;

public class MasterService extends SortableService<Master> implements IMasterService {
	@Injectable
	private IMasterStorage masterStorage;
	@Injectable
	private IOrderStorage orderStorage;

	private static final String GET_ORDER_EXECUTING_BY_CONCRETE_MASTER = "select order_id from auto_service_db.master where master_id=?";
	private static final String GET_FREE_MASTERS_ON_DATE = "select master_id, busy, name, order_id from auto_service_db.master left join from auto_service_db.order on master.order_id=order.order_id where ? < ending_date";
	private static final String REMOVE_ORDER_FROM_MASTER = "update auto_service_db.master set (order_id) values(null) where order_id=?";

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ORDER_EXECUTING_BY_CONCRETE_MASTER)) {
			statement.setLong(0, id);
			ResultSet rs = statement.executeQuery();
			return orderStorage.get(rs.getLong("order_id"));
		}
	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) throws SQLException {
		List<Master> result = new ArrayList<Master>();
		try (PreparedStatement statement = getConnection().prepareStatement(GET_FREE_MASTERS_ON_DATE)) {
			statement.setDate(0, date);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Master master = new Master(null);
				master.setId(rs.getLong("master_id"));
				master.setBusy(rs.getBoolean("busy"));
				master.setName(rs.getString("name"));
				master.setOrder(orderStorage.get(rs.getLong("order_id")));
				result.add(master);
			}
		}
		return result;

	}

	@Override
	public synchronized void addOrderToMaster(Long idOrder, Long idMaster) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Master master = getStorage().get(idMaster);
			Order order = orderStorage.get(idOrder);
			if (!order.getMasters().contains(master)) {
				master.setOrder(order);
				order.addMaster(master);
			}
			getStorage().update(master);
			orderStorage.update(order);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}

	}

	@Override
	public synchronized void removeOrderFromMaster(Long idMaster) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(REMOVE_ORDER_FROM_MASTER)) {
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
	public void create(Master entity) throws SQLException {
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
	public void update(Master entity) throws SQLException {
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
	public Master get(Long id) throws SQLException {
		Master master = getStorage().get(id);
		Order order = master.getOrder() != null ? orderStorage.get(master.getOrder().getId()) : null;
		master.setOrder(order);
		return master;
	}

	@Override
	public List<Master> getAll() throws SQLException {
		List<Master> result = getStorage().getAll();
		for (Master master : result) {
			Order order = master.getOrder() != null ? orderStorage.get(master.getOrder().getId()) : null;
			master.setOrder(order);
		}
		return result;
	}

}
