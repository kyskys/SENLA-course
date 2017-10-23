package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class AddMasterToOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getMastersAsString();
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		controller.addMasterToOrder(idMaster, idOrder);
		UIObservable.getInstance().notifyAllObservers(
				String.format("successfully added master id: %s to order id: %s", idMaster, idOrder));
	}
}
