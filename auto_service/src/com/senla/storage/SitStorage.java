package com.senla.storage;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
	private static final String GET_GARAGE_SITS_QUERY = "select * from auto_service_db.sit where garage_id = ?";
	private static final String GET_FREE_SITS_AT_DATE_QUERY = "select sit.sit_id, sit.order_id, sit.garage_id from auto_service_db.sit left join auto_service_db.order on sit.order_id = order.order_id where ending_date < ?";
	
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

	@Override
	public List<Sit> getGarageSits(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_GARAGE_SITS_QUERY)) {
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
			}
		}
		return null;
	}

	@Override
	public List<Sit> getFreeSits() throws SQLException {
		List<Sit> result = new ArrayList<Sit>();
		try (PreparedStatement statement = getConnection().prepareStatement(GET_FREE_SITS_AT_DATE_QUERY)) {
			statement.setDate(0, Date.valueOf(LocalDate.now()));
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

	@Override
	public List<Sit> getFreeSits(Date date) throws SQLException {
		List<Sit> result = new ArrayList<Sit>();
		try (PreparedStatement statement = getConnection().prepareStatement(GET_FREE_SITS_AT_DATE_QUERY)) {
			statement.setDate(0, date);
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
