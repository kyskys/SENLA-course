package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class AddSitToGarage implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		controller.addSitToGarage(idGarage);
		UIObservable.getInstance().notifyAllObservers(
				String.format("sit successfully added to garage id: %s", idGarage));
	}

}
