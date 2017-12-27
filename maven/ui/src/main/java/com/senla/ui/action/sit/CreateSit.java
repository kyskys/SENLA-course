package com.senla.ui.action.sit;

import com.senla.entities.Garage;
import com.senla.entities.Sit;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class CreateSit extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getGaragesAsString"));
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		Garage garage = (Garage) sendMessage("getGarage", idGarage);
		Sit sit = new Sit(garage);
		garage.addSit(sit);
		notifyAllObservers(sendMessage("addSit", sit));
	}
}
