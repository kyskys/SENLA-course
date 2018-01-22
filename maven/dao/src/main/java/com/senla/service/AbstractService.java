package com.senla.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jboss.logging.Logger;

import com.senla.entities.BaseEntity;
import com.senla.service.interfaces.IAbstractService;
import com.senla.storage.interfaces.IAbstractStorage;

import connector.DBConnector;

public abstract class AbstractService<T extends BaseEntity> implements IAbstractService<T> {
	private static final Logger logger = Logger.getLogger(AbstractService.class);

	abstract public IAbstractStorage<T> getStorage();

	@FunctionalInterface
	interface Action<R> {
		R execute(EntityManager manager) throws SQLException;
	}

	@FunctionalInterface
	interface SimpleAction {
		void execute(EntityManager manager) throws SQLException;
	}

	protected <R> R executeAction(Action<R> action) {
		EntityManager manager = null;
		try {
			manager = DBConnector.getManager();
			R result = action.execute(manager);
			return result;
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	protected void executeSimpleAction(SimpleAction action) {
		EntityManager manager = null;
		try {
			manager = DBConnector.getManager();
			action.execute(manager);
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	protected <R> R executeTransactionAction(Action<R> action) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = DBConnector.getManager();
			transaction = manager.getTransaction();
			transaction.begin();
			R result = action.execute(manager);
			manager.getTransaction().commit();
			return result;
		} catch (SQLException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.error(e);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	protected void executeSimpleTransactionAction(SimpleAction action) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = DBConnector.getManager();
			transaction = manager.getTransaction();
			transaction.begin();
			action.execute(manager);
			manager.getTransaction().commit();
		} catch (SQLException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.error(e);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	@Override
	public void create(T entity) {
		executeSimpleTransactionAction(manager -> getStorage().create(manager, entity));
	}

	@Override
	public void delete(T entity) {
		executeSimpleTransactionAction(manager -> getStorage().delete(manager, entity));
	}

	@Override
	public void update(T entity) {
		executeSimpleTransactionAction(manager -> getStorage().update(manager, entity));
	}

	@Override
	public T get(Long id) {
		return executeAction(manager -> getStorage().get(manager, id));
	}

	@Override
	public List<T> getAll() {
		return executeAction(manager -> getStorage().getAll(manager));
	}

}
