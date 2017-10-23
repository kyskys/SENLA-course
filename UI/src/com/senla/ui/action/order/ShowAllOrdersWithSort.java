package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class ShowAllOrdersWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type string parameter to sort with (price, start date, ending date, added date)");
		String parameter = ConsoleReader.readString();
		UIObservable.getInstance().notifyAllObservers(controller.getOrdersAsString(parameter));
	}

}
