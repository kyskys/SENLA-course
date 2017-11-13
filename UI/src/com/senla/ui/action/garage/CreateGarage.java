package com.senla.ui.action.garage;

import com.senla.entities.Garage;
import com.senla.ui.action.Action;
import com.senla.ui.util.UIUtils;

public class CreateGarage implements Action {

	@Override
	public void doAction() {
		Garage garage = new Garage();
		UIUtils.notifyAllObservers(UIUtils.sendMessage("addGarage", garage));
	}

}
