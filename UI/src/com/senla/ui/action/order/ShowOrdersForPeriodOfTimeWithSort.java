package com.senla.ui.action.order;

import java.util.Date;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class ShowOrdersForPeriodOfTimeWithSort extends Action {

	@Override
	public void doAction() {
		System.out.println("type date before");
		Date before = ConsoleReader.readDate();
		System.out.println("type date after");
		Date after = ConsoleReader.readDate();
		System.out.println("type string parameter to sort with (price, start date, ending date, added date)");
		String parameter = ConsoleReader.readString();
		notifyAllObservers(sendMessage("getOrdersForPeriodOfTimeAsString", before, after, parameter));

	}

}
