package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class AddMasterToOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showOrders();
		long idOrder = ConsoleReader.readLongByConsole();
		controller.showOrders();
		long idMaster = ConsoleReader.readLongByConsole();
		controller.addMasterToOrder(idMaster, idOrder);
		UIObservable.getInstance().notifyAllObservers(
				String.format("successfully added master id: %s to order id: %s", idMaster, idOrder));
	}
}
