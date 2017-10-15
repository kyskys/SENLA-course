package action.master;

import java.util.Date;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowFreeMastersOnDate implements Action {
	@Override
	public void doAction(IController controller) {
		Date date = ConsoleReader.readDateByConsole();
		controller.showFreeMastersOnDate(date);
	}

}
