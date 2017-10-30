package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class AddSitToGarage implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.addSitToGarage(idSit, idGarage);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(
				String.format("sit successfully added to garage id: %s", idGarage));
	}

}
