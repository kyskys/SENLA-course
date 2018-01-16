package com.senla.storage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.senla.entities.BaseEntity;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.ISortableStorage;

public abstract class SortableStorage<T extends BaseEntity> extends AbstractStorage<T> implements ISortableStorage<T> {

	static Map<SortParameters, String> sortValues;
	static {
		sortValues = new HashMap<SortParameters, String>();
		sortValues.put(SortParameters.ALPHABET, "name");
		sortValues.put(SortParameters.ADDED_DATE, "addedDate");
		sortValues.put(SortParameters.ENDING_DATE, "endingDate");
		sortValues.put(SortParameters.START_WORKING_ON_DATE, "startWorkingOnDate");
		sortValues.put(SortParameters.BUSY, "busy");
		sortValues.put(SortParameters.PRICE, "price");
	}

	public String convertToFieldName(SortParameters parameter) {
		String result = sortValues.get(parameter);
		return result != null ? result : "id";
	}

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
