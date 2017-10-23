package action.garage;

import action.Action;
import controller.IController;
import observer.UIObservable;

public class ShowAllGarages implements Action {

	@Override
	public void doAction(IController controller) {
		UIObservable.getInstance().notifyAllObservers(controller.getGaragesAsString());
		
	}

}
