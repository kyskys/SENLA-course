package action.master;

import action.Action;
import controller.IController;
import entities.Master;
import observer.UIObservable;
import util.ConsoleReader;

public class CreateMaster implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type name of master");
		String name = ConsoleReader.readString();
		Master master = new Master(name);
		controller.addMaster(master);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("master id: %s successfully created", master.getId()));
	}

}
