package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class SetOrderCancelled implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order to set cancelled");
		long idOrder = ConsoleReader.readLong();
		controller.setOrderCancelled(idOrder);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(String.format("order id: %s successfully cancelled", idOrder));
	}

}
