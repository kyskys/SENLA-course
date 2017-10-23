package action.sit;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class RemoveOrderFromSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getSitsAsString();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.removeSit(idSit);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("successfully remove order from sit id: %s", idSit));
	}

}
