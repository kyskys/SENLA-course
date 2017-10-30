package com.senla.ui.action.other;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import data.DataManager;

public class ExportEntity implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type name of file");
		String path = ConsoleReader.readString();
		controller.getMastersAsString();
		controller.getOrdersAsString();
		controller.getSitsAsString();
		controller.getGaragesAsString();
		new DataManager<>(path).save(entity);
	}

}
