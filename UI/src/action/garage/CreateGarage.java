package action.garage;

import action.Action;
import controller.IController;
import entities.Garage;
import observer.UIObservable;

public class CreateGarage implements Action {

	@Override
	public void doAction(IController controller) {
		Garage garage = new Garage();
		controller.addGarage(garage);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("garage id: %s successfully created", garage.getId()));
	}

}
