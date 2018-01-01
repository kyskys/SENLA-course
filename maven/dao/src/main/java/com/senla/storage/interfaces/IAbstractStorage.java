package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.senla.entities.BaseEntity;

public interface IAbstractStorage<T extends BaseEntity> {
	void create(EntityManager manager, T entity) throws SQLException;

	void delete(EntityManager manager, T entity) throws SQLException;

	void update(EntityManager manager, T entity) throws SQLException;

	T get(EntityManager manager, Long id) throws SQLException;

	List<T> getAll(EntityManager manager) throws SQLException;

	Class<T> getGenericClass();
}
