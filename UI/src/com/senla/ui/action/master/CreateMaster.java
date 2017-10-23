package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.entities.Master;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class CreateMaster implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type name of master");
		String name = ConsoleReader.readString();
		Master master = new Master(name);
		controller.addMaster(master);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("master id: %s successfully created", master.getId()));
	}

}
