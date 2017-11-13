package com.senla.ui.main;

import com.senla.ui.util.UIController;

import annotation.ConfigProperty;
import annotation.Injectable;
import dependency.DependencyManager;
import handler.MessageHandler;
import observer.interfaces.IObservable;
import util.AnnotationHandler;

public class Main {
	@Injectable
	@ConfigProperty()
	private static IObservable clientObserver;

	public static void main(String[] args) {
		UIController ui = new UIController();
		AnnotationHandler.configure(ui);
		ui.init();
		ui.start();
	}
}
