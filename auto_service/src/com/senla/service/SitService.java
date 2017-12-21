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

	private static final String GET_FREE_SITS_AT_DATE_QUERY = "select sit.sit_id, sit.order_id, sit.garage_id from auto_service_db.sit left join auto_service_db.order on sit.order_id = order.order_id where ending_date < ?";
	private static final String REMOVE_ORDER_FROM_SIT_QUERY = "update auto_service_db.sit set order_id = null where order_id = ?";

	@Override
	public IAbstractStorage<Sit> getStorage() {
		return sitStorage;
	}

	@Override
	public List<Sit> getFreeSits() throws SQLException {
		List<Sit> result = new ArrayList<Sit>();
		try (PreparedStatement statement = getConnection().prepareStatement(GET_FREE_SITS_AT_DATE_QUERY)) {
			statement.setDate(0, Date.valueOf(LocalDate.now()));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Sit sit = getStorage().get(rs.getLong("sit_id"));
				sit.setGarage(garageStorage.get(rs.getLong("garage_id")));
				sit.setOrder(orderStorage.get(rs.getLong("order_id")));
				result.add(sit);
			}
		}
		return result;
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) throws SQLException {
		List<Sit> result = new ArrayList<Sit>();
		try (PreparedStatement statement = getConnection().prepareStatement(GET_FREE_SITS_AT_DATE_QUERY)) {
			statement.setDate(0, date);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Sit sit = getStorage().get(rs.getLong("sit_id"));
				sit.setGarage(garageStorage.get(rs.getLong("garage_id")));
				sit.setOrder(orderStorage.get(rs.getLong("order_id")));
				result.add(sit);
			}
		}
		return result;
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
		try (PreparedStatement statement = getConnection().prepareStatement(REMOVE_ORDER_FROM_SIT_QUERY)) {
			statement.setLong(0, idSit);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sit> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
