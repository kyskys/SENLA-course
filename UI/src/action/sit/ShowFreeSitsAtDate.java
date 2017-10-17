package action.sit;

import java.util.Date;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowFreeSitsAtDate implements Action {

	@Override
	public void doAction(IController controller) {
		Date date = ConsoleReader.readDate();
		controller.showFreeSitsAtDate(date);
	}

}
