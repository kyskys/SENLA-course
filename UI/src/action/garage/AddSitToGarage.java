package action.garage;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class AddSitToGarage implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showGarages();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		controller.addSitToGarage(idGarage);
		UIObservable.getInstance().notifyAllObservers(
				String.format("sit successfully added to garage id: %s", idGarage));
	}

}
