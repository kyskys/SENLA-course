package action.sit;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class DeleteSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showSits();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.removeSit(idSit);
		UIObservable.getInstance().notifyAllObservers(String.format("sit id: %s successully deleted", idSit));
	}

}
