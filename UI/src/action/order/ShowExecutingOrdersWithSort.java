package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class ShowExecutingOrdersWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type string parameter to sort with (price, start date, added date)");
		String parameter = ConsoleReader.readString();
		UIObservable.getInstance().notifyAllObservers(controller.getExecutingOrdersAsString(parameter));
	}

}
