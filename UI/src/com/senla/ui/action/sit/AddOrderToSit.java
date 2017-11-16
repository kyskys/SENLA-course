package com.senla.ui.action.sit;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class AddOrderToSit extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getOrdersAsString"));
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("getSitsAsString"));
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("addOrderToSit", idOrder, idSit));
	}

}
