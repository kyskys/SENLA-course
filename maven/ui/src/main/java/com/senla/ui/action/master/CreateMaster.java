package com.senla.ui.action.master;

import com.senla.entities.Master;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

public class CreateMaster extends Action {

	@Override
	public void doAction() {
		System.out.println("type name of master");
		String name = ConsoleReader.readString();
		Master master = new Master(name);
		notifyAllObservers(sendMessage("addMaster", master));
	}

}
