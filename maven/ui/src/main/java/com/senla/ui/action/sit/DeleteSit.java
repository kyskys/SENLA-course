package com.senla.ui.action.sit;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class DeleteSit extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getSitsAsString"));
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("removeSit", idSit));
	}

}
