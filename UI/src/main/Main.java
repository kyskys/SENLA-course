package main;

import util.UIController;
import util.MenuBuilder;
import menu.Menu;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Menu m = MenuBuilder.buildMenu();
		UIController.start(m);
	}
}
