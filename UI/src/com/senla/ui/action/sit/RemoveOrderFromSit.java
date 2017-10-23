package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class RemoveOrderFromSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getSitsAsString();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.removeSit(idSit);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("successfully remove order from sit id: %s", idSit));
	}

}
