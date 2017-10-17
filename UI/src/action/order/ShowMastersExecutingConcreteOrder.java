package action.order;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowMastersExecutingConcreteOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showOrders();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		controller.showMastersExecutingConcreteOrder(idOrder);
	}

}
