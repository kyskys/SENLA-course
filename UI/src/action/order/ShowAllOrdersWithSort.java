package action.order;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowAllOrdersWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type string parameter to sort with (price, start date, ending date, added date)");
		String parameter = ConsoleReader.readString();
		controller.showOrders(parameter);
	}

}
