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

	@Override
	public IAbstractStorage<Garage> getStorage() {
		return garageStorage;
	}

	@Override
	public void addSitToGarage(Long idGarage, Long idSit) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Garage garage = garageStorage.get(idGarage);
			Sit sit = sitStorage.get(idSit);
			if (!garage.getSits().contains(sit)) {
				garage.addSit(sit);
				sit.setGarage(garage);
			}
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
	public void removeSitFromGarage(Long idSit, Long idGarage) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			Garage garage = garageStorage.get(idGarage);
			Sit sit = sitStorage.get(idSit);
			garage.removeSit(sit);
			sitStorage.delete(idSit);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public void create(Garage entity) throws SQLException {
		try {
			getConnection().setAutoCommit(false);
			garageStorage.create(entity);
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
			garageStorage.delete(id);
			getConnection().commit();
			getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			getConnection().rollback();
		} finally {
			getConnection().setAutoCommit(true);
		}
	}

	@Override
	public Garage get(Long id) throws SQLException {
			Garage garage = garageStorage.get(id);
			garage.setSits(sitStorage.getGarageSits(id));
			return garage;
	}

	@Override
	public List<Garage> getAll() throws SQLException {
		List<Garage> garages = null;
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
