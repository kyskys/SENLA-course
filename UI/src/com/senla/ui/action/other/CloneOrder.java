package com.senla.ui.action.other;

import com.senla.controller.IController;
import com.senla.entities.Order;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class CloneOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order to clone");
		long id = ConsoleReader.readLong();
		Order original = controller.getOrder(id);
		Order clone = original.clone();
		controller.addOrder(clone);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("order id: %s successfully cloned, new id: %s", id, clone.getId()));
	}

}
