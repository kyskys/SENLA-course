package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;

import dependency.DependencyManager;

public class ShowFreeSits implements Action {

	@Override
	public void doAction(IController controller) {
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getFreeSitsAsString());
	}

}
