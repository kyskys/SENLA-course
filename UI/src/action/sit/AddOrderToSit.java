package action.sit;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class AddOrderToSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showOrders();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		controller.showSits();
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.addOrderToSit(idOrder, idSit);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("successfully added order id: %s to sit id: %s", idOrder, idSit));
	}

}
