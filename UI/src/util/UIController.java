package util;

import menu.Menu;
import observer.UIObservable;

public class UIController {
	public static void start(Menu menu) throws IllegalArgumentException, IllegalAccessException {
		while (menu != null) {
			menu.showMenu();
			long n = ConsoleReader.readLongByConsole();
			try {
				menu = menu.getList().get((int) (n - 1)).doWork();
			} catch (IllegalArgumentException e) {
				UIObservable.getInstance().notifyAllObservers(e);
			}
		}
	}
}