package action.master;

import action.Action;
import controller.IController;

public class SortMastersByAlphabet implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showMasters("aphabet");
	}

}
