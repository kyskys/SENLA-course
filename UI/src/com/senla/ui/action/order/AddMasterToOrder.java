package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;
import observer.interfaces.IObservable;

public class AddMasterToOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getMastersAsString();
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		controller.addMasterToOrder(idMaster, idOrder);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(
				String.format("successfully added master id: %s to order id: %s", idMaster, idOrder));
	}
}
