package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class ShowOrderExecutingByConcreteMaster implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getOrderExecutingByConcreteMasterAsString(idMaster));
	}

}
