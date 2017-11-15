package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.observer.interfaces.IObservable;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class DeleteGarage extends Action {

	@Override
	public void doAction() {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		controller.removeGarage(idGarage);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(String.format("garage id: %s successfully deleted", idGarage));
	}

}
