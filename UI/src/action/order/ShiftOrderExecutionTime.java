package action.order;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShiftOrderExecutionTime implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type days to shift orders");
		int days = ConsoleReader.readInt();
		controller.shiftOrdersTimeExecution(days);
	}

}
