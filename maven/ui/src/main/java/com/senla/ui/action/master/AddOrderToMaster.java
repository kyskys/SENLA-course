package com.senla.ui.action.master;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class AddOrderToMaster extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getMastersAsString"));
		long idMaster = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("getOrdersAsString"));
		long idOrder = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("addOrderToMaster", idOrder, idMaster));
	}

}
