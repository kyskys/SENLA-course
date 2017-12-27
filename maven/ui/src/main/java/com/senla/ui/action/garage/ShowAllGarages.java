package com.senla.ui.action.garage;

import com.senla.ui.action.Action;

public class ShowAllGarages extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getGaragesAsString"));
	}

}
