package action.master;

import action.Action;
import controller.IController;

public class SortMastersByBusy implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showMasters("busy");
	}

}
