package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;
import util.Utils;

public class RemoveMasterFromOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		System.out.println(Utils.getListAsString(controller.getOrder(idOrder).getMasters()));
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.removeMasterFromOrder(idMaster, idOrder);
		UIObservable.getInstance().notifyAllObservers(
				String.format("successfully remove master id: %s from order id: %s", idMaster, idOrder));

	}

}
