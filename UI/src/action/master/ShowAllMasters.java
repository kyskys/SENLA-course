package action.master;

import action.Action;
import controller.IController;

public class ShowAllMasters implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showMasters();
	}

}
