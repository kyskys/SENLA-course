package action.order;

import java.util.Date;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowOrdersForPeriodOfTimeWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type date before");
		Date before = ConsoleReader.readDate();
		System.out.println("type date after");
		Date after = ConsoleReader.readDate();
		System.out.println("type string parameter to sort with (price, start date, ending date, added date");
		String parameter = ConsoleReader.readString();
		controller.showOrdersForPeriodOfTime(before, after, parameter);

	}

}
