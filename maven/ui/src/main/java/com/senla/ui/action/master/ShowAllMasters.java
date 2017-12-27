package com.senla.ui.action.master;

import com.senla.ui.action.Action;

public class ShowAllMasters extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getMastersAsString"));
	}

}
