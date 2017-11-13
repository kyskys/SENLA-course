package com.senla.ui.action.garage;

import com.senla.controller.IController;
import com.senla.ui.action.Action;
import com.senla.ui.util.ConsoleReader;

import dependency.DependencyManager;
import handler.MessageHandler;
import observer.interfaces.IObservable;

public class AddSitToGarage implements Action {

	@Override
	public void doAction(MessageHandler socket) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.addSitToGarage(idSit, idGarage);
		DependencyManager.getInstance(IObservable.class).notifyAllObservers(
				String.format("sit successfully added to garage id: %s", idGarage));
	}

}
