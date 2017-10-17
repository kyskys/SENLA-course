package action.sit;

import action.Action;
import controller.IController;

public class ShowAllSits implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showSits();
	}

}
