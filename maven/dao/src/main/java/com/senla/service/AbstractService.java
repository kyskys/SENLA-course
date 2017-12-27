package com.senla.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.senla.entities.BaseEntity;
import com.senla.service.interfaces.IAbstractService;
import com.senla.storage.interfaces.IAbstractStorage;

import connector.DBConnector;

public abstract class AbstractService<T extends BaseEntity> implements IAbstractService<T> {

	abstract public IAbstractStorage<T> getStorage();

	<R> R executeWithTransaction(TransactionAction<R> action, R defaultValue) {
		Transaction transaction = null;
		try (Session session = DBConnector.getSession()) {
			transaction = session.beginTransaction();
			R result = action.execute(session);
			transaction.commit();
			return result;
		} catch (Throwable e) {
			transaction.rollback();
		}
		return defaultValue;
	}

	<R> R executeWithTransaction(TransactionAction<R> action) {
		return executeWithTransaction(action, null);
	}

	@FunctionalInterface
	interface TransactionAction<R> {
		R execute(Session session);
	}
}
