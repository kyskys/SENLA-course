package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class SetOrderCancelled implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showOrders();
		System.out.println("type id of order to set cancelled");
		long idOrder = ConsoleReader.readLong();
		controller.setOrderCancelled(idOrder);
		UIObservable.getInstance().notifyAllObservers(String.format("order id: %s successfully cancelled", idOrder));
	}

}
