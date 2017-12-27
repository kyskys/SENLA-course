package com.senla.ui.action.master;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class RemoveOrderFromMaster extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getMastersAsString"));
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("removeOrderFromMaster", idMaster));
	}

}
