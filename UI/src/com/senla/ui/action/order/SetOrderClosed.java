package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;
import observer.interfaces.IObservable;

public class SetOrderClosed implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order to set closed");
		long idOrder = ConsoleReader.readLong();
		controller.setOrderClosed(idOrder);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(String.format("order id: %s successfully closed", idOrder));

	}

}
