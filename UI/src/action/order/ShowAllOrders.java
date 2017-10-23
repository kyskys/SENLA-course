package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;

public class ShowAllOrders implements Action {

	@Override
	public void doAction(IController controller) {
		UIObservable.getInstance().notifyAllObservers(controller.getOrdersAsString());
	}

}
