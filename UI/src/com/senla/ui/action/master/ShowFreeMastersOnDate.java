package com.senla.ui.action.master;

import java.util.Date;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class ShowFreeMastersOnDate implements Action {
	@Override
	public void doAction(IController controller) {
		Date date = ConsoleReader.readDate();
		UIObservable.getInstance().notifyAllObservers(controller.showFreeMastersOnDate(date));
	}

}
