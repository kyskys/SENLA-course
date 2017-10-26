package com.senla.ui.action.sit;

import java.util.Date;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class ShowFreeSitsAtDate implements Action {

	@Override
	public void doAction(IController controller) {
		Date date = ConsoleReader.readDate();
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(controller.getFreeSitsAtDateAsString(date));
	}

}
