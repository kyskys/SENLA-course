package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;

import dependency.DependencyManager;

public class ShowAllGarages implements Action {

	@Override
	public void doAction(IController controller) {
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getGaragesAsString());
		
	}

}
