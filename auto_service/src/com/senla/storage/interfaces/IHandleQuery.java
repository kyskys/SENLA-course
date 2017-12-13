package com.senla.storage.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.senla.entities.BaseEntity;

public interface IHandleQuery<T extends BaseEntity> {
	
	boolean handleCreateQuery(PreparedStatement state, T entity) throws SQLException;

	boolean handleDeleteQuery(PreparedStatement state, Long id) throws SQLException;

	T handleGetQuery(PreparedStatement state, Long id) throws SQLException;

	List<T> handleSelectAllQuery(PreparedStatement state) throws SQLException;

}
