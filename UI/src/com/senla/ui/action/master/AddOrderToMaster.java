package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class AddOrderToMaster implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getMastersAsString();
		long idMaster = ConsoleReader.readLong();
		controller.getOrdersAsString();
		long idOrder = ConsoleReader.readLong();
		controller.addOrderToMaster(idOrder, idMaster);
		UIObservable.getInstance().notifyAllObservers(
				String.format("successfully added order id: %s to master id: %s", idOrder, idMaster));
	}

}
