package com.senla.storage;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.stereotype.Service;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.storage.interfaces.IMasterStorage;

@Service
public class MasterStorage extends SortableStorage<Master> implements IMasterStorage {

	@Override
	public Class<Master> getGenericClass() {
		return Master.class;
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(EntityManager manager, Long id) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		root.fetch("masters");
		Subquery<Long> subQuery = query.subquery(Long.class);
		Root<Master> subRoot = subQuery.from(Master.class);
		query.select(root).where(builder.equal(root.get("id"),
				subQuery.select(subRoot.get("order")).where(builder.equal(subRoot.get("id"), id))));
		TypedQuery<Order> result = manager.createQuery(query);
		return result.getSingleResult();
	}

	@Override
	public List<Master> getFreeMastersOnDate(EntityManager manager, Date date) throws SQLException {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Master> query = builder.createQuery(Master.class);
		Root<Master> root = query.from(Master.class);
		Subquery<Order> subQuery = query.subquery(Order.class);
		Root<Order> subRoot = subQuery.from(Order.class);
		query.select(root).where(root.get("order")
				.in(subQuery.select(subRoot).where(builder.lessThan(subRoot.get("endingDate"), date))));
		TypedQuery<Master> result = manager.createQuery(query);
		return result.getResultList();
	}

	@Override
	protected void joinLazyFields(Root<?> root) {

	}
}
