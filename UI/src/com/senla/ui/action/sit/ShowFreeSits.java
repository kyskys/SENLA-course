package com.senla.ui.action.sit;

import com.senla.ui.action.Action;

public class ShowFreeSits extends Action {

	@Override
	public void doAction() {
		notifyAllObservers(sendMessage("getFreeSitsAsString"));
	}

}
