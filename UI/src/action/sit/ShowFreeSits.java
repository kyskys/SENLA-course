package action.sit;

import action.Action;
import controller.IController;

public class ShowFreeSits implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showFreeSits();
	}

}
