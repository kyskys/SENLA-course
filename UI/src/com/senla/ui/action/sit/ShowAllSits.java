package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.observer.interfaces.IObservable;
import com.senla.ui.action.Action;

import dependency.DependencyManager;

public class ShowAllSits implements Action {

	@Override
	public void doAction(IController controller) {
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getSitsAsString());
	}

}
