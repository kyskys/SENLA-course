package com.senla.ui.action.garage;

import com.senla.entities.Garage;
import com.senla.ui.action.Action;

public class CreateGarage extends Action {

	@Override
	public void doAction() {
		Garage garage = new Garage();
		notifyAllObservers(sendMessage("addGarage", garage));
	}
}
