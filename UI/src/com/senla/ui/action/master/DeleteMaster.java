package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.observer.interfaces.IObservable;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class DeleteMaster implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getMastersAsString();
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.removeMaster(idMaster);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(String.format("master id: %s successfully deleted", idMaster));
	}

}
