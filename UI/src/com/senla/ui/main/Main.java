package com.senla.ui.main;

import com.senla.ui.util.UIController;

import annotation.ConfigProperty;
import annotation.Configurable;
import annotation.Injectable;
import handlers.ConfigPropertyHandler;
import handlers.ConfigurableHandler;
import handlers.InjectableHandler;
import util.AnnotationHandler;

public class Main {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		UIController ui = new UIController();
		AnnotationHandler pc = new AnnotationHandler();
		pc.addAnnotationHandlerToMap(Configurable.class, new ConfigurableHandler());
		pc.addAnnotationHandlerToMap(Injectable.class, new InjectableHandler());
		pc.addAnnotationHandlerToMap(ConfigProperty.class, new ConfigPropertyHandler());
		pc.configure(ui);
		ui.init();
		ui.start();
		ui.end();
	}
}
