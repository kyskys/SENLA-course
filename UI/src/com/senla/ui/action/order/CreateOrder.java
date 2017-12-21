package com.senla.ui.action.order;

import java.sql.Date;

import com.senla.entities.Order;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class CreateOrder extends Action {

	@Override
	public void doAction() {
		System.out.println("type price");
		double price = ConsoleReader.readLong();
		System.out.println("type ending date");
		Date endingDate = ConsoleReader.readDate();
		System.out.println("type start working on date");
		Date startDate = ConsoleReader.readDate();
		Order Order = new Order(price, endingDate, startDate);
		notifyAllObservers(sendMessage("addOrder", Order));
	}

}
