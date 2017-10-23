package com.senla.ui.action.order;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.observer.UIObservable;
import com.senla.ui.util.ConsoleReader;

public class ShiftOrderExecutionTime implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type days to shift orders");
		int days = ConsoleReader.readInt();
		controller.shiftOrdersTimeExecution(days);
		UIObservable.getInstance().notifyAllObservers("successfully shifted");
	}

}
