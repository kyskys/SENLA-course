package com.senla.ui.action.order;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class SetOrderClosed extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getOrdersAsString"));
		System.out.println("type id of order to set closed");
		long idOrder = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("setOrderClosed", idOrder));
	}

}
