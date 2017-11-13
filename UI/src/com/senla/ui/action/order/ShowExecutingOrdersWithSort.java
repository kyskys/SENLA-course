package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;
import observer.interfaces.IObservable;

public class ShowExecutingOrdersWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type string parameter to sort with (price, start date, added date)");
		String parameter = ConsoleReader.readString();
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getExecutingOrdersAsString(parameter));
	}

}
