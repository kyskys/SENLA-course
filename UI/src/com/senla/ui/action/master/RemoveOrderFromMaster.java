package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class RemoveOrderFromMaster implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getMastersAsString();
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.removeOrderFromMaster(idMaster);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("successfully remove order from master id: %s", idMaster));
	}

}
