package com.senla.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senla.entities.Garage;
import com.senla.storage.interfaces.IGarageStorage;

import util.ConnectionManager;

public class GarageStorage extends AbstractStorage<Garage> implements IGarageStorage {
	public GarageStorage() {
		super("insert into auto_service_db.garage(idgarage) values(?)", "delete from garage where idgarage = ?",
				"select * from auto_service_db.garage(idgarage)", "select * from garage where idgarage = ?");
	}

	@Override
	public boolean handleCreateQuery(PreparedStatement state, Garage entity) throws SQLException {
		state.setLong(0, entity.getId());
		return ConnectionManager.executeTransaction(state) != null;
	}

	@Override
	public boolean handleDeleteQuery(PreparedStatement state, Long id) throws SQLException {
		state.setLong(0, id);
		return ConnectionManager.executeTransaction(state) != null;
	}

	@Override
	public Garage handleGetQuery(PreparedStatement state, Long id) throws SQLException {
		return null;
		/*
		 * state.setLong(0, id); ResultSet res =
		 * ConnectionManager.executeTransaction(state); Garage garage = new
		 * Garage(); garage.setId(res.get); return garage;
		 */
	}

	@Override
	public List<Garage> handleSelectAllQuery(PreparedStatement state) throws SQLException {
		List<Garage> list = new ArrayList<Garage>();
		ResultSet res = ConnectionManager.executeTransaction(state);
		while (res.next()) {
			Garage garage = new Garage();
			garage.setId(Long.getLong(res.getString(0)));
			list.add(garage);
		}
		return list;
	}

}
