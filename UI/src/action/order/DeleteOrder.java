package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class DeleteOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		controller.removeOrder(idOrder);
		UIObservable.getInstance().notifyAllObservers(String.format("order id: %s successully deleted", idOrder));
	}

}
