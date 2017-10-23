package action.sit;

import action.Action;
import controller.IController;
import observer.UIObservable;

public class ShowAllSits implements Action {

	@Override
	public void doAction(IController controller) {
		UIObservable.getInstance().notifyAllObservers(controller.getSitsAsString());
	}

}
