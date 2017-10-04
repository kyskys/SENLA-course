package main;

import util.Controller;
import util.MenuBuilder;
import menu.Menu;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Menu m = MenuBuilder.buildMenu();
		Controller.start(m);
	}
}
