package com.senla.ui.action.order;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class ShowAllOrdersWithSort extends Action {

	@Override
	public void doAction() {
		System.out.println("type string parameter to sort with (price, start date, ending date, added date)");
		String parameter = ConsoleReader.readString();
		notifyAllObservers(sendMessage("getOrdersAsString", parameter));
	}

}
