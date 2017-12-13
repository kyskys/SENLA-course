package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.senla.entities.BaseEntity;

public interface IAbstractStorage<T extends BaseEntity> {
	boolean create(T Entity) throws SQLException;

	boolean delete(Long id) throws SQLException;

	T get(Long id) throws SQLException;

	List<T> getAll() throws SQLException;

}
