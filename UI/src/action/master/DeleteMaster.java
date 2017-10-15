package action.master;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class DeleteMaster implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showMasters();
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLongByConsole();
		controller.removeMaster(idMaster);
		UIObservable.getInstance().notifyAllObservers(String.format("master id: %s successully deleted", idMaster));
	}

}
