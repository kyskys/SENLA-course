package action.garage;

import action.Action;
import controller.IController;

public class ShowAllGarages implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showGarages();
	}

}
