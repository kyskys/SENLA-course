package com.senla.ui.action.other;

import java.io.IOException;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import data.*;
import util.AnnotationHandler;

public class ExportEntity implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type name of file");
		String fileName = ConsoleReader.readString();
		System.out.println("choose entity:\n1) master\n2) order\n3) sit\n4)garage");
		DataManager<?> dm;
		while (true) {
			int entityName = ConsoleReader.readInt();
			if (entityName == 1) {
				dm = new DataManager<>(fileName, new MasterSCVManager());
				break;
			} else if (entityName == 2) {
				dm = new DataManager<>(fileName, new OrderSCVManager());
				break;
			} else if (entityName == 3) {
				dm = new DataManager<>(fileName, new SitSCVManager());
				break;
			} else if (entityName == 4) {
				dm = new DataManager<>(fileName, new GarageSCVManager());
				break;
			} else {
				System.out.println("wrong number");
			}
		}
		AnnotationHandler.configure(dm);
		try {
			dm.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dm.exportEntities();
	}

}