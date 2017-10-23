package com.senla.ui.observer;

import org.apache.logging.log4j.LogManager;

import com.senla.ui.observer.interfaces.IObserver;

public class InfoLogger implements IObserver {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(InfoLogger.class);

	@Override
	public void display(String str) {
		logger.info(str);
	}
}
