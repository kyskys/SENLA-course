package com.senla.storage;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.storage.interfaces.ISitStorage;

public class SitStorage extends AbstractStorage<Sit> implements ISitStorage {

	@Override
	public Class<Sit> getGenericClass() {
		return Sit.class;
	}

	@Override
	public List<Sit> getFreeSits(EntityManager manager) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Sit> query = builder.createQuery(Sit.class);
		Root<Sit> root = query.from(Sit.class);
		Subquery<Order> subQuery = query.subquery(Order.class);
		Root<Order> subRoot = subQuery.from(Order.class);
		query.select(root).where(root.get("order").in(subQuery.select(subRoot)
				.where(builder.lessThan(subRoot.get("endingDate"), Date.valueOf(LocalDate.now())))));
		TypedQuery<Sit> sits = manager.createQuery(query);
		return sits.getResultList();
	}

	@Override
	public List<Sit> getFreeSitsAtDate(EntityManager manager, Date date) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Sit> query = builder.createQuery(Sit.class);
		Root<Sit> root = query.from(Sit.class);
		Subquery<Order> subQuery = query.subquery(Order.class);
		Root<Order> subRoot = subQuery.from(Order.class);
		query.select(root).where(root.get("order")
				.in(subQuery.select(subRoot).where(builder.lessThan(subRoot.get("endingDate"), date))));
		TypedQuery<Sit> sits = manager.createQuery(query);
		return sits.getResultList();
	}

	@Override
	protected void joinLazyFields(Root<?> root) {
		
	}

}
