package util;

import menu.Menu;

public class UIController {
	public static void start(Menu menu) throws IllegalArgumentException, IllegalAccessException {
		while (menu != null) {
			menu.showMenu();
			long n = ConsoleReader.readLongByConsole();
			menu = menu.getList().get((int) (n - 1)).doWork();
		}
	}
}