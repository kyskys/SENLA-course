package action.other;

import action.Action;
import controller.IController;
import entities.Order;
import observer.UIObservable;
import util.ConsoleReader;

public class CloneOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order to clone");
		long id = ConsoleReader.readLong();
		Order original = controller.getOrder(id);
		Order clone = original.clone();
		controller.addOrder(clone);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("order id: %s successfully cloned, new id: %s", id, clone.getId()));
	}

}
