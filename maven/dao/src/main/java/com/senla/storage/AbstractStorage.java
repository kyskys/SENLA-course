package com.senla.storage;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.senla.entities.BaseEntity;
import com.senla.storage.interfaces.IAbstractStorage;

public abstract class AbstractStorage<T extends BaseEntity> implements IAbstractStorage<T> {

	@Override
	public void create(Session session, T entity) throws SQLException {
		session.save(entity);
	}

	@Override
	public void delete(Session session, T entity) throws SQLException {
		session.delete(entity);
	}

	@Override
	public void update(Session session, T entity) throws SQLException {
		session.update(entity);
	}

	@Override
	public T get(Session session, Long id) throws SQLException {
		return (T) session.get(getGenericClass(), id);
	}

	@Override
	public List<T> getAll(Session session) throws SQLException {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		query.select(root);
		Query<T> result = session.createQuery(query);
		return result.getResultList();
	}

}
