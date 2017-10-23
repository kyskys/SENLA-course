package com.senla.ui.action.sit;

import com.senla.controller.IController;
import com.senla.entities.Sit;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class CreateSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		Sit sit = new Sit(controller.getGarage(idGarage));
		controller.addSit(sit);
		UIObservable.getInstance().notifyAllObservers(String.format("successfully created sit id: %s", sit.getId()));
	}
}
