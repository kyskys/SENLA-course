package com.senla.storage;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.senla.entities.BaseEntity;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.ISortableStorage;

public abstract class SortableStorage<T extends BaseEntity> extends AbstractStorage<T> implements ISortableStorage<T> {
	
	public List<T> getAll(Session session, SortParameters parameter) throws SQLException {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getGenericClass());
		Root<T> root = query.from(getGenericClass());
		query.select(root);
		query.orderBy(builder.asc(root.get(convertToFieldName(parameter))));
		Query<T> result = session.createQuery(query);
		return result.getResultList();
	}

}
