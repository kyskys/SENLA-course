package com.senla.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Garage;
import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.service.interfaces.ISitService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IGarageStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISitStorage;

import annotation.Injectable;

public class SitService extends AbstractService<Sit> implements ISitService {
	@Injectable
	private ISitStorage sitStorage;
	@Injectable
	private IOrderStorage orderStorage;
	@Injectable
	private IGarageStorage garageStorage;
	
	@Override
	public IAbstractStorage<Sit> getStorage() {
		return sitStorage;
	}

	@Override
	public List<Sit> getFreeSits() throws SQLException {
		return sitStorage.getFreeSits();
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) throws SQLException {
		return sitStorage.getFreeSits(date);
	}

	@Override
	public synchronized void addOrderToSit(Long idOrder, Long idSit) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Order order = orderStorage.get(idOrder);
			Sit sit = sitStorage.get(idSit);
			sit.setOrder(order);
			orderStorage.update(order);
			sitStorage.update(sit);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public synchronized void removeOrderFromSit(Long idSit) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Sit sit = sitStorage.get(idSit);
			sit.setOrder(null);
			sitStorage.update(sit);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public synchronized void addGarageToSit(Long idGarage, Long idSit) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Sit sit = sitStorage.get(idSit);
			Garage garage = garageStorage.get(idGarage);
			sit.setGarage(garage);
			garage.addSit(sit);
			sitStorage.update(sit);
			garageStorage.update(garage);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public synchronized void removeGarageFromSit(Long idGarage, Long idSit) throws SQLException {
		try {
			getStorage().delete(idSit);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public void create(Sit entity) throws SQLException {
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
	public void update(Sit entity) throws SQLException {
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
	public Sit get(Long id) throws SQLException {
		Sit sit = getStorage().get(id);
		sit.setOrder(orderStorage.get(sit.getOrder().getId()));
		sit.setGarage(garageStorage.get(sit.getGarage().getId()));
		return sit;
	}

	@Override
	public List<Sit> getAll() throws SQLException {
		List<Sit> result = getStorage().getAll();
		for (Sit sit : result) {
			sit = getStorage().get(sit.getId());
		}
		return result;
	}

}
