package com.senla.ui.util;

import com.senla.controller.Controller;
import com.senla.controller.IController;
import com.senla.manager.ServiceManager;
import com.senla.manager.StorageManager;
import com.senla.manager.interfaces.IServiceManager;
import com.senla.manager.interfaces.IStorageManager;
import com.senla.ui.menu.Menu;
import com.senla.ui.observer.ConsoleDisplayer;
import com.senla.ui.observer.ErrorLogger;
import com.senla.ui.observer.InfoLogger;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.observer.interfaces.IExceptionObserver;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.observer.interfaces.IObserver;
import com.senla.ui.serialisation.Serializer;

import config.AutoServiceConfig;

public class UIController {
	private static IController controller;
	private static Serializer serializer;
	private static AutoServiceConfig config;

	public static void init() {
		try {
			config = new AutoServiceConfig();
			config.init();
			IObservable observable = UIObservable.getInstance();
			IObserver logger = new InfoLogger();
			IObserver consoleDisplayer = new ConsoleDisplayer();
			IExceptionObserver errorLogger = new ErrorLogger();
			observable.addObserver(errorLogger);
			observable.addObserver(logger);
			observable.addObserver(consoleDisplayer);
			IStorageManager storageManager = new StorageManager();
			IServiceManager serviceManager = new ServiceManager(storageManager);
			controller = new Controller(serviceManager);
			serializer = new Serializer(storageManager, config.getSerializerFileName(), config.getSerializerFilePath());
			serializer.updateProperties();
			serializer.load();
		} catch (Throwable e) {
			UIObservable.getInstance().notifyAllObservers(e);
		}
	}

	public static void start() {
		Menu menu = null;
		try {
			menu = MenuBuilder.buildMenu(controller, config);
		} catch (Throwable e) {
			UIObservable.getInstance().notifyAllObservers(e);
		}
		while (menu != null) {
			menu.showMenu();
			long n = ConsoleReader.readLong();
			try {
				menu = menu.getList().get((int) (n - 1)).doWork();
			} catch (Throwable e) {
				UIObservable.getInstance().notifyAllObservers(e);
			}
		}

	}

	public static void end() {
		try {
			serializer.save();
		} catch (Throwable e) {
			UIObservable.getInstance().notifyAllObservers(e);
		}
	}
}