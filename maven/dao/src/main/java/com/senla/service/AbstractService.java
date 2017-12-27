package com.senla.service;

import java.sql.Connection;

import com.senla.entities.BaseEntity;
import com.senla.service.interfaces.IAbstractService;
import com.senla.storage.interfaces.IAbstractStorage;

import connector.DBConnector;

public abstract class AbstractService<T extends BaseEntity> implements IAbstractService<T> {

	static {
		connection = DBConnector.getConnection();
	}

	private static Connection connection;

	public static Connection getConnection() {
		return connection;
	}

	abstract public IAbstractStorage<T> getStorage();

}
