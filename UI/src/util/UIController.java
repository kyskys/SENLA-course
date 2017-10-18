package util;
import java.io.IOException;

import controller.Controller;
import controller.IController;
import manager.ServiceManager;
import manager.StorageManager;
import manager.interfaces.IServiceManager;
import manager.interfaces.IStorageManager;
import menu.Menu;
import observer.ConsoleDisplayer;
import observer.ErrorLogger;
import observer.InfoLogger;
import observer.UIObservable;
import observer.interfaces.IExceptionObserver;
import observer.interfaces.IObservable;
import observer.interfaces.IObserver;
import serialisation.Serializer;

public class UIController {
	private static IController controller;
	private static Serializer serializer;
	public static void init() {
		try {
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
			serializer = new Serializer(storageManager);
			serializer.load();
		} catch (Throwable e) {
			UIObservable.getInstance().notifyAllObservers(e);
		}
	}

	public static void start() throws IOException {
		Menu menu = MenuBuilder.buildMenu(controller);
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