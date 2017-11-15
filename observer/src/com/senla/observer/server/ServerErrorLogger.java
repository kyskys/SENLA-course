package com.senla.observer.server;

import org.apache.logging.log4j.LogManager;

import com.senla.observer.interfaces.IExceptionObserver;

public class ServerErrorLogger implements IExceptionObserver {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ServerErrorLogger.class);

	@Override
	public void display(Throwable e) {
		logger.error(e.getClass(), e);
	}
}
