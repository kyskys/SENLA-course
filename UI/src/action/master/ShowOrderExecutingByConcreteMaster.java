package action.master;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class ShowOrderExecutingByConcreteMaster implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		UIObservable.getInstance().notifyAllObservers(controller.getOrderExecutingByConcreteMasterAsString(idMaster));
	}

}
