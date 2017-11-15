package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.entities.Garage;
import com.senla.observer.interfaces.IObservable;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;
import com.senla.util.Utils;

import dependency.DependencyManager;

public class RemoveSitFromGarage implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		Garage garage = controller.getGarage(idGarage);
		System.out.println(Utils.getListAsString(garage.getSits()));
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.removeSitFromGarage(idSit, idGarage);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(
				String.format("sit id: %s successfully removed from garage id: %s", idSit, idGarage));

	}

}
