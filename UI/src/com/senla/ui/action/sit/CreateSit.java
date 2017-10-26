package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.entities.Sit;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;

public class CreateSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		Sit sit = new Sit(controller.getGarage(idGarage));
		controller.addSit(sit);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(String.format("successfully created sit id: %s", sit.getId()));
	}
}
