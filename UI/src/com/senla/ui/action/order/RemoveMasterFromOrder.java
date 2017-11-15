package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.observer.interfaces.IObservable;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;
import com.senla.util.Utils;

import dependency.DependencyManager;

public class RemoveMasterFromOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		System.out.println(Utils.getListAsString(controller.getOrder(idOrder).getMasters()));
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.removeMasterFromOrder(idMaster, idOrder);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(
				String.format("successfully remove master id: %s from order id: %s", idMaster, idOrder));

	}

}
