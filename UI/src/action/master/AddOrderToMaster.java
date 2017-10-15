package action.master;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class AddOrderToMaster implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showMasters();
		long idMaster = ConsoleReader.readLongByConsole();
		controller.showOrders();
		long idOrder = ConsoleReader.readLongByConsole();
		controller.addOrderToMaster(idOrder, idMaster);
		UIObservable.getInstance().notifyAllObservers(
				String.format("successfully added order id: %s to master id: %s", idOrder, idMaster));
	}

}
