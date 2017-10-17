package main;

import util.UIController;
import util.MenuBuilder;
import controller.Controller;
import controller.IController;
import data.DataManager;
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

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		IObservable observable = UIObservable.getInstance();
		IObserver logger = new InfoLogger();
		IObserver consoleDisplayer = new ConsoleDisplayer();
		IExceptionObserver errorLogger = new ErrorLogger();
		observable.addObserver(logger);
		observable.addObserver(consoleDisplayer);
		IStorageManager storageManager = new StorageManager();
		IServiceManager serviceManager = new ServiceManager(storageManager);
		IController controller = new Controller(serviceManager);
		DataManager fm = new DataManager(storageManager, args[0], args[1], args[2], args[3]);
		fm.load();
		Menu menu = MenuBuilder.buildMenu(controller);
		UIController.start(menu);
		fm.save();
	}
}
