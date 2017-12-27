package com.senla.observer.ui;

import org.apache.logging.log4j.LogManager;

import com.senla.observer.interfaces.IObserver;

public class InfoLogger implements IObserver {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(InfoLogger.class);

	@Override
	public void display(String str) {
		logger.info(str);
	}
}
