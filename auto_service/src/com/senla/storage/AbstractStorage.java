package com.senla.storage;

import java.sql.Connection;

import com.senla.entities.BaseEntity;
import com.senla.storage.interfaces.IAbstractStorage;

import connector.DBConnector;

public abstract class AbstractStorage<T extends BaseEntity> implements IAbstractStorage<T> {

	static {
		connection = DBConnector.getConnection();
	}

	private static Connection connection;

	public Connection getConnection() {
		return connection;
	}
	
}
