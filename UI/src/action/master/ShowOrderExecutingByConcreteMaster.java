package action.master;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class ShowOrderExecutingByConcreteMaster implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type id of master");
		long idMaster = ConsoleReader.readLong();
		controller.showOrderExecutingByConcreteMaster(idMaster);
	}

}
