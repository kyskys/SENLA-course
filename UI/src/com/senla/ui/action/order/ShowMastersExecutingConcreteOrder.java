package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;
import observer.interfaces.IObservable;

public class ShowMastersExecutingConcreteOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getMastersExecutingConcreteOrderAsString(idOrder));
	}

}
