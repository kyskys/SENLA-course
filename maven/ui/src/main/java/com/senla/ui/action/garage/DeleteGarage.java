package com.senla.ui.action.garage;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class DeleteGarage extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getGaragesAsString"));
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("removeGarage", idGarage));
	}

}
