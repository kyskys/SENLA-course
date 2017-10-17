package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class SetOrderClosed implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showOrders();
		System.out.println("type id of order to set closed");
		long idOrder = ConsoleReader.readLong();
		controller.setOrderClosed(idOrder);
		UIObservable.getInstance().notifyAllObservers(String.format("order id: %s successfully closed", idOrder));

	}

}
