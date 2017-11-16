package com.senla.ui.action.master;

import java.util.Date;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class ShowFreeMastersOnDate extends Action {
	@Override
	public void doAction() {
		Date date = ConsoleReader.readDate();
		notifyAllObservers(sendMessage("showFreeMastersOnDate", date));
	}

}
