package com.senla.ui.action.other;

import com.senla.entities.Order;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class CloneOrder extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getOrdersAsString"));
		System.out.println("type id of order to clone");
		long id = ConsoleReader.readLong();
		Order original = (Order) sendMessage("getOrder", id);
		Order clone = original.clone();
		notifyAllObservers(sendMessage("addOrder", clone));
	}
}
