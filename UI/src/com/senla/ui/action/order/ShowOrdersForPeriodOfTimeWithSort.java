package com.senla.ui.action.order;

import java.util.Date;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class ShowOrdersForPeriodOfTimeWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type date before");
		Date before = ConsoleReader.readDate();
		System.out.println("type date after");
		Date after = ConsoleReader.readDate();
		System.out.println("type string parameter to sort with (price, start date, ending date, added date)");
		String parameter = ConsoleReader.readString();
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getOrdersForPeriodOfTimeAsString(before, after, parameter));

	}

}
