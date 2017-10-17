package action.master;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowAllMastersWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type string parameter to sort with (busy,alphabet)");
		String parameter = ConsoleReader.readString();
		controller.showMasters(parameter);
	}

}
