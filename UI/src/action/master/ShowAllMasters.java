package action.master;

import action.Action;
import controller.IController;
import observer.UIObservable;

public class ShowAllMasters implements Action {

	@Override
	public void doAction(IController controller) {
		UIObservable.getInstance().notifyAllObservers(controller.getMastersAsString());
	}

}
