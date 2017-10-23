package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class AddOrderToSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		controller.getSitsAsString();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.addOrderToSit(idOrder, idSit);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("successfully added order id: %s to sit id: %s", idOrder, idSit));
	}

}
