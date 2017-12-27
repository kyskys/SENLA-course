package com.senla.ui.action.sit;

import com.senla.ui.action.Action;

public class ShowAllSits extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getSitsAsString"));
	}

}
