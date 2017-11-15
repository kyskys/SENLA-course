package com.senla.ui.util;

import java.io.IOException;

import com.senla.message.Message;
import com.senla.observer.interfaces.IObservable;
import com.senla.ui.menu.Menu;

import annotation.Configurable;
import annotation.Injectable;
import handler.MessageHandler;

public class UIController {
	@Injectable
	@Configurable
	private IObservable observable;
	@Injectable
	private MessageHandler handler;
	@Configurable
	private MenuBuilder mb = new MenuBuilder();

	public void start() {
		try {
			Menu menu = null;
			menu = mb.buildMenu();
			while (menu != null) {
				menu.showMenu();
				long n = ConsoleReader.readLong();
				try {
					menu = menu.getList().get((int) (n - 1)).doWork();
				} catch (Throwable e) {
					observable.notifyAllObservers(e);
				}
			}
			handler.send(new Message("avada kedavra"));
		} catch (ClassNotFoundException | IOException e) {
			observable.notifyAllObservers(e);
		}

	}
}