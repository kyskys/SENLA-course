package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class ShowOrderExecutingByConcreteMaster implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		UIObservable.getInstance().notifyAllObservers(controller.getOrderExecutingByConcreteMasterAsString(idMaster));
	}

}
