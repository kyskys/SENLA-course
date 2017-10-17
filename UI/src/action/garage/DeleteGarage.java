package action.garage;

import action.Action;
import controller.IController;
import util.ConsoleReader;

public class DeleteGarage implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showGarages();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		controller.removeGarage(idGarage);
		System.out.println(String.format("garage id: %s successfully deleted", idGarage));
	}

}
