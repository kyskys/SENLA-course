package com.senla.service.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.senla.entities.BaseEntity;

public interface IAbstractService<T extends BaseEntity> {
	void create(T entity) throws SQLException;

	void delete(Long id) throws SQLException;

	void update(T entity) throws SQLException;

	T get(Long id) throws SQLException;

	List<T> getAll() throws SQLException;
}
