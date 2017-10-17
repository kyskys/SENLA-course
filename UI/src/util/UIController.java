package util;

import menu.Menu;
import observer.UIObservable;

public class UIController {
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