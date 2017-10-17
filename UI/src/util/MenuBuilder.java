package util;

import action.garage.CreateGarage;
import action.sit.CreateSit;
import controller.IController;
import menu.Menu;
import menu.MenuPoint;

public class MenuBuilder {
	public static Menu buildMenu(IController controller) {
		Menu mainMenu = new Menu("main menu");
		mainMenu.add(new MenuPoint(null, null, "exit"));
		mainMenu.add(new MenuPoint(controller, mainMenu, "create garage", new CreateGarage()));
		mainMenu.add(new MenuPoint(controller, mainMenu, "throw error", new CreateSit()));
		return mainMenu;
	}

}
