package com.senla.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senla.entities.Garage;
import com.senla.storage.interfaces.IGarageStorage;

public class GarageStorage extends AbstractStorage<Garage> implements IGarageStorage {
	private static final String CREATE_QUERY = "insert into auto_service_db.garage(garage_id) values(?)";
	private static final String DELETE_QUERY = "delete from auto_service_db.garage where garage_id = ?";
	private static final String UPDATE_QUERY = "update auto_service_db.garage set garage_id = ? where garage_id = ?";
	private static final String GET_ONE_QUERY = "select * from auto_service_db.garage where garage_id = ?";
	private static final String GET_ALL_QUERY = "select * from auto_service_db.garage";
	private static final String DELETE_GARAGE_FROM_SITS_QUERY = "update auto_service_db.sit set (garage_id) values (null) where garage_id = ?";
	
	@Override
	public void create(Garage entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
			statement.setLong(0, entity.getId());
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
	public Garage get(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
			statement.setLong(0, id);
			ResultSet rs = statement.executeQuery();
			Garage garage = new Garage();
			garage.setId(rs.getLong("garage_id"));
			return garage;
		}
	}

	@Override
	public List<Garage> getAll() throws SQLException {
		List<Garage> result = new ArrayList<Garage>();
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ALL_QUERY)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Garage garage = new Garage();
				garage.setId(rs.getLong("garage_id"));
				result.add(garage);
			}
			return result;
		}
	}

	@Override
	public void update(Garage entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
			statement.setLong(0, entity.getId());
			statement.executeQuery();
		}
	}
}
