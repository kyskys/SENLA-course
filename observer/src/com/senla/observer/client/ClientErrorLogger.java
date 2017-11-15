package com.senla.observer.client;

import org.apache.logging.log4j.LogManager;

import com.senla.observer.interfaces.IExceptionObserver;

public class ClientErrorLogger implements IExceptionObserver {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ClientErrorLogger.class);

	@Override
	public void display(Throwable e) {
		logger.error(e.getClass(), e);
	}
}
