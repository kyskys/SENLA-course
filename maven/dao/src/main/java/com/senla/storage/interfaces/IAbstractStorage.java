package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.senla.entities.BaseEntity;

public interface IAbstractStorage<T extends BaseEntity> {
	void create(Session session, T entity) throws SQLException;

	void delete(Session session, T entity) throws SQLException;

	void update(Session session, T entity) throws SQLException;

	T get(Session session, Long id) throws SQLException;

	List<T> getAll(Session session) throws SQLException;

	Class<T> getGenericClass();
}
