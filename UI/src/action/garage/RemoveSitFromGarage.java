package action.garage;

import action.Action;
import controller.IController;
import entities.Garage;
import observer.UIObservable;
import util.ConsoleReader;
import util.Utils;

public class RemoveSitFromGarage implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		Garage garage = controller.getGarage(idGarage);
		System.out.println(Utils.getListAsString(garage.getSits()));
		System.out.println("type id of sit");
		long idSit = ConsoleReader.readLong();
		controller.removeSitFromGarage(idSit, idGarage);
		UIObservable.getInstance().notifyAllObservers(
				String.format("sit id: %s successfully removed from garage id: %s", idSit, idGarage));

	}

}
