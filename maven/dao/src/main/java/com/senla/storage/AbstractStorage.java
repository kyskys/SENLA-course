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

	protected abstract void joinLazyFields(Root<?> root);
	
	@Override
	public void create(EntityManager manager, T entity) throws SQLException {
		manager.persist(entity);
	}

	@Override
	public void delete(EntityManager manager, T entity) throws SQLException {
		manager.remove(manager.merge(entity));
	}

	@Override
	public void update(EntityManager manager, T entity) throws SQLException {
		manager.merge(entity);
	}

	@Override
	public T get(EntityManager manager, Long id) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		joinLazyFields(root);
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<T> result = manager.createQuery(query);
		return result.getSingleResult();
	}

	@Override
	public List<T> getAll(EntityManager manager) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		joinLazyFields(root);
		query.select(root);
		TypedQuery<T> result = manager.createQuery(query);
		return result.getResultList();
	}
}
