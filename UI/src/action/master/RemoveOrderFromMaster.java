package action.master;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class RemoveOrderFromMaster implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getMastersAsString();
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.removeOrderFromMaster(idMaster);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("successfully remove order from master id: %s", idMaster));
	}

}
