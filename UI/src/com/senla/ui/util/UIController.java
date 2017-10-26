package com.senla.ui.util;

import com.senla.ui.menu.Menu;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.serialisation.Serializer;

import annotation.ConfigProperty;
import annotation.Configurable;
import annotation.PropertyConfigurator;

public class UIController {
	@Configurable
	private UIObservable observable = new UIObservable();
	PropertyConfigurator pc = new PropertyConfigurator();
	@ConfigProperty(configName = "config.properties", propertyName = "UIController.serializerFileName")
	private String serializerFileName;
	@ConfigProperty(configName = "config.properties", propertyName = "UIController.serializerFilePath")
	private String serializerFilePath;
	private static Serializer serializer;
	

	public void init() {
		try {
			// IObserver logger = new InfoLogger();
			// IObserver consoleDisplayer = new ConsoleDisplayer();
			// IExceptionObserver errorLogger = new ErrorLogger();
			// observable.addObserver(errorLogger);
			// observable.addObserver(logger);
			// observable.addObserver(consoleDisplayer);
			serializer = new Serializer(serializerFilePath, serializerFileName);
			serializer.updateProperties();
			serializer.load();
		} catch (Throwable e) {
			observable.notifyAllObservers(e);
		}
	}

	public void start() {
		Menu menu = null;

		try {
			MenuBuilder mb = new MenuBuilder();
			pc.configure(mb);
			menu = mb.buildMenu();
		} catch (Throwable e) {
			observable.notifyAllObservers(e);
		}
		while (menu != null) {
			menu.showMenu();
			long n = ConsoleReader.readLong();
			try {
				menu = menu.getList().get((int) (n - 1)).doWork();
			} catch (Throwable e) {
				observable.notifyAllObservers(e);
			}
		}

	}

	public void end() {
		try {
			serializer.save();
		} catch (Throwable e) {
			observable.notifyAllObservers(e);
		}
	}
}