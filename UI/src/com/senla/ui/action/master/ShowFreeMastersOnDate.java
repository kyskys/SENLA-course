package com.senla.ui.action.master;

import java.util.Date;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;
import observer.interfaces.IObservable;

public class ShowFreeMastersOnDate implements Action {
	@Override
	public void doAction(IController controller) {
		Date date = ConsoleReader.readDate();
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.showFreeMastersOnDate(date));
	}

}
