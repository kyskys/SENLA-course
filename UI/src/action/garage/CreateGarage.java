package action.garage;

import action.Action;
import controller.Controller;
import entities.Garage;
import observer.UIObservable;

public class CreateGarage implements Action {

	@Override
	public void doAction() {
		Garage garage = new Garage();
		Controller.getInstance().addGarage(garage);
		UIObservable.getInstance().notifyAllObservers("garage created");
	}

}
