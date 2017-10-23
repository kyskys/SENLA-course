package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.entities.Garage;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;

public class CreateGarage implements Action {

	@Override
	public void doAction(IController controller) {
		Garage garage = new Garage();
		controller.addGarage(garage);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("garage id: %s successfully created", garage.getId()));
	}

}
