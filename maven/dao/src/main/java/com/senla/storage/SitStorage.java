package com.senla.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senla.entities.Garage;
import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.storage.interfaces.ISitStorage;

public class SitStorage extends AbstractStorage<Sit> implements ISitStorage {
	private static final String CREATE_QUERY = "insert into auto_service_db.sit(sit_id,garage_id,order_id) values(?,?,?)";
	private static final String DELETE_QUERY = "delete from auto_service_db.sit where sit_id = ?";
	private static final String UPDATE_QUERY = "update auto_service_db.sit set sit_id = ? garage_id = ? order_id = ? where sit_id = ?";
	private static final String GET_ONE_QUERY = "select * from auto_service_db.sit where sit_id = ?";
	private static final String GET_ALL_QUERY = "select * from auto_service_db.sit";

	@Override
	public void create(Sit entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
			statement.setLong(0, entity.getId());
			statement.setLong(1, entity.getGarage() != null ? entity.getGarage().getId() : null);
			statement.setLong(2, entity.getOrder() != null ? entity.getOrder().getId() : null);
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
	public void update(Sit entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
			statement.setLong(0, entity.getId());
			statement.setLong(1, entity.getGarage() != null ? entity.getGarage().getId() : null);
			statement.setLong(2, entity.getOrder() != null ? entity.getOrder().getId() : null);
		}
	}

	@Override
	public Sit get(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
			ResultSet rs = statement.executeQuery();
			Sit sit = new Sit();
			sit.setId(rs.getLong("sit_id"));
			Garage garage = new Garage();
			garage.setId(rs.getLong("garage_id"));
			sit.setGarage(garage);
			Order order = new Order();
			order.setId(rs.getLong("order_id"));
			sit.setOrder(order);
			return sit;
		}
	}

	@Override
	public List<Sit> getAll() throws SQLException {
		List<Sit> result = new ArrayList<Sit>();
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ALL_QUERY)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Sit sit = new Sit();
				sit.setId(rs.getLong("sit_id"));
				Garage garage = new Garage();
				garage.setId(rs.getLong("garage_id"));
				sit.setGarage(garage);
				Order order = new Order();
				order.setId(rs.getLong("order_id"));
				sit.setOrder(order);
				result.add(sit);
			}
		}
		return result;
	}

}
