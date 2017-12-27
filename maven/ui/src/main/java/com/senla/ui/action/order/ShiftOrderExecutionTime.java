package com.senla.ui.action.order;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class ShiftOrderExecutionTime extends Action {

	@Override
	public void doAction() {
		System.out.println("type days to shift orders");
		int days = ConsoleReader.readInt();
		notifyAllObservers(sendMessage("shiftOrdersTimeExecution", days));
	}

}
