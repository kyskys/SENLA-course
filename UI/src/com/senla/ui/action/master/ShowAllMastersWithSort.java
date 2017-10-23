package com.senla.ui.action.master;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class ShowAllMastersWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type string parameter to sort with (busy,alphabet)");
		String parameter = ConsoleReader.readString();
		UIObservable.getInstance().notifyAllObservers(controller.getMastersAsString(parameter));
	}

}
