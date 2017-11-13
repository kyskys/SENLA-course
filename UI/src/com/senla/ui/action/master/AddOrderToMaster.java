package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;
import observer.interfaces.IObservable;

public class AddOrderToMaster implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println(controller.getMastersAsString());
		long idMaster = ConsoleReader.readLong();
		System.out.println(controller.getOrdersAsString());
		long idOrder = ConsoleReader.readLong();
		controller.addOrderToMaster(idOrder, idMaster);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(
				String.format("successfully added order id: %s to master id: %s", idOrder, idMaster));
	}

}
