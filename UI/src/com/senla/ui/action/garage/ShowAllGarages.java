package com.senla.ui.action.garage;

import com.senla.ui.action.Action;
import com.senla.ui.util.UIUtils;

public class ShowAllGarages implements Action {

	@Override
	public void doAction() {
		UIUtils.notifyAllObservers(UIUtils.sendMessage("getGaragesAsString"));
	}

}
