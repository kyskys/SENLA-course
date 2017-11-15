package com.senla.ui.action.other;

import com.senla.ui.action.Action;

public class SerializeData extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("serialize"));
	}

}
