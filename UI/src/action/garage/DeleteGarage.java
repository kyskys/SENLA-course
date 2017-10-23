package action.garage;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class DeleteGarage implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		controller.removeGarage(idGarage);
		UIObservable.getInstance().notifyAllObservers(String.format("garage id: %s successfully deleted", idGarage));
	}

}
