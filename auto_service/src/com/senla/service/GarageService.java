package com.senla.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.senla.entities.Garage;
import com.senla.entities.Sit;
import com.senla.service.interfaces.IGarageService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IGarageStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISitStorage;

import annotation.Injectable;

public class GarageService extends AbstractService<Garage> implements IGarageService {
	@Injectable
	private IGarageStorage garageStorage;
	@Injectable
	private ISitStorage sitStorage;
	@Injectable
	private IOrderStorage orderStorage;

	private static final String DELETE_GARAGE_FROM_SITS = "update auto_service_db.sit set (garage_id) values (null) where garage_id = ?";
	private static final String GET_GARAGE_SITS = "select * from auto_service_db.sit where garage_id = ?";

	@Override
	public IAbstractStorage<Garage> getStorage() {
		return garageStorage;
	}

	@Override
	public void addSitToGarage(Long idGarage, Long idSit) throws SQLException {
		Garage garage = garageStorage.get(idGarage);
		Sit sit = sitStorage.get(idSit);
		if (!garage.getSits().contains(sit)) {
			garage.addSit(sit);
			sit.setGarage(garage);
		}
		sitStorage.update(sit);
		garageStorage.update(garage);
	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) throws SQLException {
		sitStorage.delete(idSit);
	}

	@Override
	public void create(Garage entity) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			getStorage().create(entity);
			for (Sit sit : entity.getSits()) {
				sitStorage.create(sit);
			}
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		}
	}

	@Override
	public void delete(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(DELETE_GARAGE_FROM_SITS)) {
			getConnection().setAutoCommit(false);
			getStorage().delete(id);
			statement.setLong(0, id);
			statement.executeUpdate();
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}

	}

	@Override
	public Garage get(Long id) throws SQLException {
		Garage garage = getStorage().get(id);
		try (PreparedStatement statement = getConnection().prepareStatement(GET_GARAGE_SITS)) {
			statement.setLong(0, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Sit sit = new Sit(null);
				sit.setId(rs.getLong("sit_id"));
				sit.setOrder(orderStorage.get(rs.getLong("order_id")));
				sit.setGarage(garage);
				garage.addSit(sit);
			}
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
		return garage;

	}

	@Override
	public List<Garage> getAll() throws SQLException {
		List<Garage> garages = getStorage().getAll();
		for (Garage garage : garages) {
			garage = get(garage.getId());
		}
		return garages;
	}

	@Override
	public void update(Garage entity) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			getStorage().update(entity);
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

}
