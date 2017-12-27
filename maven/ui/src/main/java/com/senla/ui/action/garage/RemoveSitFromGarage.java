package com.senla.ui.action.garage;

import com.senla.entities.Garage;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;
import com.senla.util.Utils;

public class RemoveSitFromGarage extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getGaragesAsString"));
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		Garage garage = (Garage) sendMessage("getGarage", idGarage);
		System.out.println(Utils.getListAsString(garage.getSits()));
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("removeSitFromGarage", idSit, idGarage));
	}

}
