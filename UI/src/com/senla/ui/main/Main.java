package com.senla.ui.main;

import com.senla.ui.util.UIController;

import util.AnnotationHandler;

public class Main {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		UIController ui = new UIController();
		AnnotationHandler.configure(ui);
		ui.init();
		ui.start();
		ui.end();
	}
}
