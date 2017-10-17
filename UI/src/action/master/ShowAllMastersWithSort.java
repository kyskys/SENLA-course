package action.master;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowAllMastersWithSort implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type parameter to sort with:\n1) busy\n2)alphabet");
		String parameter = ConsoleReader.readStringByConsole();
		controller.showMasters(parameter);
	}

}
