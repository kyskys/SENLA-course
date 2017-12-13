package com.senla.storage;

import java.sql.SQLException;
import java.util.List;
import com.senla.entities.BaseEntity;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IHandleQuery;

import util.ConnectionManager;

public abstract class AbstractStorage<T extends BaseEntity> implements IAbstractStorage<T>, IHandleQuery<T> {
	protected String createQuery;
	protected String deleteQuery;
	protected String selectAllQuery;
	protected String selectQuery;

	AbstractStorage(String... queries) {
		createQuery = queries[0];
		deleteQuery = queries[1];
		selectAllQuery = queries[2];
		selectQuery = queries[3];
	}

	@Override
	public boolean create(T entity) throws SQLException {
		return handleCreateQuery(ConnectionManager.getStatement(createQuery), entity);
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		return handleDeleteQuery(ConnectionManager.getStatement(deleteQuery), id);
	}

	@Override
	public List<T> getAll() throws SQLException {
		return handleSelectAllQuery(ConnectionManager.getStatement(selectAllQuery));
	}

	@Override
	public T get(Long id) throws SQLException {
		return handleGetQuery(ConnectionManager.getStatement(selectQuery), id);
	}
	
}
