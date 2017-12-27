package com.senla.ui.action.master;

import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class ShowOrderExecutingByConcreteMaster extends Action {

	@Override
	public void doAction() {
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		notifyAllObservers(sendMessage("getOrderExecutingByConcreteMasterAsString", idMaster));
	}

}
