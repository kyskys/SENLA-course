package com.senla.ui.action.order;

import java.util.Date;

import com.senla.controller.IController;
import com.senla.entities.Order;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class CreateOrder implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type price");
		double price = ConsoleReader.readLong();
		System.out.println("type ending date");
		Date endingDate = ConsoleReader.readDate();
		System.out.println("type start working on date");
		Date startDate = ConsoleReader.readDate();
		Order Order = new Order(price, endingDate, startDate);
		controller.addOrder(Order);
		DependencyManager.getInstance(IObservable.class)
				.notifyAllObservers(String.format("order id: %s successfully created", Order.getId()));

	}

}
