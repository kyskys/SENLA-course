package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;

import dependency.DependencyManager;
import observer.interfaces.IObservable;

public class ShowAllOrders implements Action {

	@Override
	public void doAction(IController controller) {
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getOrdersAsString());
	}

}
