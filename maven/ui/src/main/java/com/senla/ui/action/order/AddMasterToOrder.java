package com.senla.ui.action.order;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class AddMasterToOrder extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getMastersAsString"));
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("getOrdersAsString"));
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("addMasterToOrder", idMaster, idOrder));
	}
}
