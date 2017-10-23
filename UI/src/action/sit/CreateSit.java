package action.sit;

import action.Action;
import controller.IController;
import entities.Sit;
import observer.UIObservable;
import util.ConsoleReader;

public class CreateSit implements Action {

	@Override
	public void doAction(IController controller) {
		controller.getGaragesAsString();
		System.out.println("type id of garage");
		long idGarage = ConsoleReader.readLong();
		Sit sit = new Sit(controller.getGarage(idGarage));
		controller.addSit(sit);
		UIObservable.getInstance().notifyAllObservers(String.format("successfully created sit id: %s", sit.getId()));
	}
}
