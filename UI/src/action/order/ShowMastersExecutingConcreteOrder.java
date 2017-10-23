package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class ShowMastersExecutingConcreteOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getOrdersAsString();
		System.out.println("type id of order");
		long idOrder = ConsoleReader.readLong();
		UIObservable.getInstance().notifyAllObservers(controller.getMastersExecutingConcreteOrderAsString(idOrder));
	}

}
