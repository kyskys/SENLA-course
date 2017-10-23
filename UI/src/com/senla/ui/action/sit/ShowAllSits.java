package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;

public class ShowAllSits implements Action {

	@Override
	public void doAction(IController controller) {
		UIObservable.getInstance().notifyAllObservers(controller.getSitsAsString());
	}

}
