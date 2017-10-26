package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class DeleteSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getSitsAsString();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.removeSit(idSit);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(String.format("sit id: %s successully deleted", idSit));
	}

}
