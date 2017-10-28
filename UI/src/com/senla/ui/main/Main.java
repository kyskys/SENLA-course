package com.senla.ui.main;

import com.senla.ui.util.UIController;

import handlers.AnnotationHandler;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		UIController ui = new UIController();
		AnnotationHandler pc = new AnnotationHandler();
		pc.configure(ui);
		ui.init();
		ui.start();
		ui.end();
	}
}
