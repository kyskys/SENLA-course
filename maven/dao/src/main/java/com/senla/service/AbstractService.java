package com.senla.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.senla.entities.BaseEntity;
import com.senla.service.interfaces.IAbstractService;
import com.senla.storage.interfaces.IAbstractStorage;

import connector.DBConnector;

public abstract class AbstractService<T extends BaseEntity> implements IAbstractService<T> {

	abstract public IAbstractStorage<T> getStorage();

	@FunctionalInterface
	interface TransactionAction<R> {
		R execute(EntityManager manager) throws SQLException;
	}

	@FunctionalInterface
	interface SimpleTransactionAction {
		void execute(EntityManager manager) throws SQLException;
	}

	protected <R> R executeTransactionAction(TransactionAction<R> action) throws Throwable {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = DBConnector.getManager();
			transaction = manager.getTransaction();
			transaction.begin();
			R result = action.execute(manager);
			manager.getTransaction().commit();
			return result;
		} catch (Throwable e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Throwable(e);
		} finally

		{
			if (manager != null) {
				manager.close();
			}
		}
	}

	void executeSimpleTransactionAction(SimpleTransactionAction action) throws Throwable {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = DBConnector.getManager();
			transaction = manager.getTransaction();
			transaction.begin();
			action.execute(manager);
			manager.getTransaction().commit();
		} catch (Throwable e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Throwable(e);
		} finally

		{
			if (manager != null) {
				manager.close();
			}
		}
	}

	@Override
	public void create(T entity) throws Throwable {
		executeSimpleTransactionAction(manager -> getStorage().create(manager, entity));
	}

	@Override
	public void delete(T entity) throws Throwable {
		executeSimpleTransactionAction(manager -> getStorage().delete(manager, entity));
	}

	@Override
	public void update(T entity) throws Throwable {
		executeSimpleTransactionAction(manager -> getStorage().update(manager, entity));
	}

	@Override
	public T get(Long id) throws Throwable {
		return executeTransactionAction(manager -> getStorage().get(manager, id));
	}

	@Override
	public List<T> getAll() throws Throwable {
		return executeTransactionAction(manager -> getStorage().getAll(manager));
	}

}
