package util;

import controller.Controller;
import controller.IController;
import loader.ConfigLoader;
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
	public static void init() {
		try {
			ConfigLoader config = new ConfigLoader();
			IObservable observable = UIObservable.getInstance();
			IObserver logger = new InfoLogger();
			IObserver consoleDisplayer = new ConsoleDisplayer();
			IExceptionObserver errorLogger = new ErrorLogger();
			observable.addObserver(errorLogger);
			observable.addObserver(logger);
			observable.addObserver(consoleDisplayer);
			IStorageManager storageManager = new StorageManager();
			IServiceManager serviceManager = new ServiceManager(storageManager);
			IController controller = new Controller(serviceManager);
			Serializer data = new Serializer(storageManager, config.config().get("serializerFilePath").toString());
			data.load();
			Menu menu = MenuBuilder.buildMenu(controller);
			UIController.start(menu);
			data.save();
		} catch (Throwable e) {
			UIObservable.getInstance().notifyAllObservers(e);
		}
	}

	public static void start(Menu menu) {
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
}