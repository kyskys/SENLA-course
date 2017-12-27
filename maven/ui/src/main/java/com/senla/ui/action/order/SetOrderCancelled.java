package com.senla.ui.action.order;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class SetOrderCancelled extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getOrdersAsString"));
		System.out.println("type id of order to set cancelled");
		long idOrder = ConsoleReader.readLong();
		sendMessage("setOrderCancelled", idOrder);
		notifyAllObservers(String.format("order id: %s successfully cancelled", idOrder));
	}

}
