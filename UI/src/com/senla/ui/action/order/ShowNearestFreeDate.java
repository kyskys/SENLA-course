package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;

public class ShowNearestFreeDate implements Action {

	@Override
	public void doAction(IController controller) {
		UIObservable.getInstance().notifyAllObservers(controller.getNearestFreeDateAsString());
	}

}
