package util;

import menu.Menu;
import menu.MenuPoint;

public class MenuBuilder {
	public static Menu buildMenu() {
		Menu mainMenu = new Menu("main menu");
		mainMenu.add(new MenuPoint(null, "exit"));
		return mainMenu;
	}

}
