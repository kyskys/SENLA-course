package com.senla.ui.action.order;

import com.senla.entities.Order;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;
import com.senla.util.Utils;

public class RemoveMasterFromOrder extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getOrdersAsString"));
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		Order order = (Order) sendMessage("getOrder");
		notifyAllObservers(Utils.getListAsString(order.getMasters()));
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("removeMasterFromOrder", idMaster, idOrder));
	}

}
