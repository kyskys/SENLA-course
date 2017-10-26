package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.entities.Garage;
import com.senla.ui.action.Action;
import com.senla.ui.observer.interfaces.IObservable;

import dependency.DependencyManager;

public class CreateGarage implements Action {

	@Override
	public void doAction(IController controller) {
		Garage garage = new Garage();
		controller.addGarage(garage);
		DependencyManager.getInstance(IObservable.class)
				.notifyAllObservers(String.format("garage id: %s successfully created", garage.getId()));
	}

}
