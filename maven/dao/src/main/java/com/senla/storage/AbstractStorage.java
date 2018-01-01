package com.senla.storage;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.senla.entities.BaseEntity;
import com.senla.storage.interfaces.IAbstractStorage;

public abstract class AbstractStorage<T extends BaseEntity> implements IAbstractStorage<T> {

	@Override
	public void create(EntityManager manager, T entity) throws SQLException {
		manager.persist(entity);
	}

	@Override
	public void delete(EntityManager manager, T entity) throws SQLException {
		manager.remove(entity);
	}

	@Override
	public void update(EntityManager manager, T entity) throws SQLException {
		manager.merge(entity);
	}

	@Override
	public T get(EntityManager manager, Long id) throws SQLException {
		return (T) manager.find(getGenericClass(), id);
	}

	@Override
	public List<T> getAll(EntityManager manager) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		query.select(root);
		TypedQuery<T> result = manager.createQuery(query);
		return result.getResultList();
	}

}
