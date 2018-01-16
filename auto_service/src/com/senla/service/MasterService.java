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

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) throws SQLException {
		return masterStorage.getFreeMastersOnDate(date);
	}

	@Override
	public synchronized void addOrderToMaster(Long idOrder, Long idMaster) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Master master = masterStorage.get(idMaster);
			Order order = orderStorage.get(idOrder);
			if (!order.getMasters().contains(master)) {
				master.setOrder(order);
				order.addMaster(master);
			}
			masterStorage.update(master);
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
	public synchronized void removeOrderFromMaster(Long idMaster, Long idOrder) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Master master = masterStorage.get(idMaster);
			Order order = orderStorage.get(idOrder);
			order.removeMaster(master);
			master.setOrder(null);
			masterStorage.update(master);
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
	public void create(Master entity) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			masterStorage.create(entity);
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
			masterStorage.delete(id);
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
			masterStorage.update(entity);
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
		Master master = masterStorage.get(id);
		Order order = master.getOrder() != null ? orderStorage.get(master.getOrder().getId()) : null;
		master.setOrder(order);
		return master;
	}

	@Override
	public List<Master> getAll() throws SQLException {
		List<Master> result = masterStorage.getAll();
		for (Master master : result) {
			Order order = master.getOrder() != null ? orderStorage.get(master.getOrder().getId()) : null;
			master.setOrder(order);
		}
		return result;
	}

}
