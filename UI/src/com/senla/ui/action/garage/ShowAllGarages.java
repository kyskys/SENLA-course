package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;

public class ShowAllGarages implements Action {

	@Override
	public void doAction(IController controller) {
		UIObservable.getInstance().notifyAllObservers(controller.getGaragesAsString());
		
	}

}
