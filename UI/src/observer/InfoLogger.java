package observer;

import org.apache.logging.log4j.LogManager;

import observer.interfaces.IObserver;

public class InfoLogger implements IObserver {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getRootLogger();

	@Override
	public void display(String str) {
		logger.info(str);
	}
}
