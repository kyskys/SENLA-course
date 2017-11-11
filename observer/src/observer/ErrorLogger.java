package observer;

import org.apache.logging.log4j.LogManager;

import observer.interfaces.IExceptionObserver;

public class ErrorLogger implements IExceptionObserver {
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ErrorLogger.class);

	@Override
	public void display(Throwable e) {
		logger.error(e.getClass(), e);
	}
}
