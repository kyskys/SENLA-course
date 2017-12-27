package com.senla.ui.action.sit;

import java.util.Date;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class ShowFreeSitsAtDate extends Action {

	@Override
	public void doAction() {
		Date date = ConsoleReader.readDate();
		notifyAllObservers(sendMessage("getFreeSitsAtDateAsString", date));
	}

}
