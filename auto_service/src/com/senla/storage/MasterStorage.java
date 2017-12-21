package com.senla.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.IMasterStorage;

public class MasterStorage extends SortableStorage<Master> implements IMasterStorage {

	private static final String CREATE_QUERY = "insert into auto_service_db.master(master_id,name,busy,order_id) values(?,?,?,?)";
	private static final String DELETE_QUERY = "delete from auto_service_db.master where master_id = ?";
	private static final String UPDATE_QUERY = "update auto_service_db.master set master_id = ? busy = ? name = ? where master_id = ?";
	private static final String GET_ONE_QUERY = "select * from auto_service_db.master where master_id = ?";
	private static final String GET_ALL_QUERY = "select * from auto_service_db.master";

	@Override
	public void create(Master entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
			statement.setLong(0, entity.getId());
			statement.setBoolean(1, entity.isBusy());
			statement.setString(2, entity.getName());
			statement.setLong(3, entity.getOrder() != null ? entity.getOrder().getId() : null);
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
	public Master get(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
			statement.setLong(0, id);
			ResultSet rs = statement.executeQuery();
			Master master = new Master();
			master.setId(rs.getLong("master_id"));
			master.setName(rs.getString("name"));
			master.setBusy(rs.getBoolean("busy"));
			Order order = new Order(0, null, null);
			order.setId(rs.getLong("order_id"));
			master.setOrder(order);
			return master;
		}
	}

	@Override
	public void update(Master entity) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
			statement.setLong(0, entity.getId());
			statement.setBoolean(1, entity.isBusy());
			statement.setString(2, entity.getName());
			statement.setLong(3, entity.getOrder() != null ? entity.getOrder().getId() : null);
			statement.executeQuery();
		}
	}

	@Override
	public List<Master> getAll(SortParameters parameter) throws SQLException {
		List<Master> result = new ArrayList<Master>();
		try (PreparedStatement statement = getConnection()
				.prepareStatement(String.format("%s order by %s", GET_ALL_QUERY, sort(parameter)))) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Master master = new Master();
				master.setId(rs.getLong("master_id"));
				master.setName(rs.getString("name"));
				master.setBusy(rs.getBoolean("busy"));
				Order order = new Order(0, null, null);
				order.setId(rs.getLong("order_id"));
				master.setOrder(order);
				result.add(master);
			}
			return result;
		}
	}

	@Override
	protected String sort(SortParameters parameter) throws SQLException {
		switch (parameter) {
		case ALPHABET: {
			return "name";
		}
		case BUSY: {
			return "busy";
		}
		default:
			return "master_id";
		}
	}

	@Override
	public List<Master> getAll() throws SQLException {
		return getAll(null);
	}

}
