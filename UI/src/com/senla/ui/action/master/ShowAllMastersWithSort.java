package com.senla.ui.action.master;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class ShowAllMastersWithSort extends Action {

	@Override
	public void doAction() {
		System.out.println("type string parameter to sort with (busy,alphabet)");
		String parameter = ConsoleReader.readString();
		notifyAllObservers(sendMessage("getMastersAsString", parameter));
	}

}
