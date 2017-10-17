package action.order;

import java.util.Date;

import action.Action;
import controller.IController;
import entities.Order;
import observer.UIObservable;
import util.ConsoleReader;

public class CreateOrder implements Action {

	@Override
	public void doAction(IController controller) {
		System.out.println("type price");
		double price = ConsoleReader.readLong();
		System.out.println("type ending date");
		Date endingDate = ConsoleReader.readDate();
		System.out.println("type start working on date");
		Date startDate = ConsoleReader.readDate();
		Order Order = new Order(price, endingDate, startDate);
		controller.addOrder(Order);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("order id: %s successfully created", Order.getId()));

	}

}
