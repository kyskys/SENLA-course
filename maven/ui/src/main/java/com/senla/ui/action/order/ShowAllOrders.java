package com.senla.ui.action.order;

import com.senla.ui.action.Action;

public class ShowAllOrders extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getOrdersAsString"));
	}

}
