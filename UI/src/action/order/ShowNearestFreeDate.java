package action.order;

import action.Action;
import controller.IController;

public class ShowNearestFreeDate implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showNearestFreeDate();
	}

}
