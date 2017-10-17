package action.order;

import action.Action;
import controller.IController;

public class ShowAllOrders implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showOrders();
	}

}
