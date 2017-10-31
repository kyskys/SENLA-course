package com.senla.ui.action.other;

import java.io.IOException;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;
import data.*;

public class ExportEntity implements Action {

	@Override
	public void doAction(IController controller) throws IOException {
		System.out.println("type name of file");
		String fileName = ConsoleReader.readString();
		System.out.println("choose entity:\n1) master\n2) order\n3) sit\n4) garage");
		DataManager<?> dm = null;
		int num = ConsoleReader.readIntWithBounds(4, 1);
		if (num == 1) {
			dm = new DataManager<>(fileName, new MasterSCVManager());

		} else if (num == 2) {
			dm = new DataManager<>(fileName, new OrderSCVManager());

		} else if (num == 3) {
			dm = new DataManager<>(fileName, new SitSCVManager());

		} else if (num == 4) {
			dm = new DataManager<>(fileName, new GarageSCVManager());
		}
		dm.init();
		dm.exportEntities();
	}
}