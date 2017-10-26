package com.senla.ui.main;

import com.senla.ui.util.UIController;

import annotation.PropertyConfigurator;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		UIController ui = new UIController();
		PropertyConfigurator pc = new PropertyConfigurator();
		pc.configure(ui);
		ui.init();
		ui.start();
		ui.end();
	}
}
