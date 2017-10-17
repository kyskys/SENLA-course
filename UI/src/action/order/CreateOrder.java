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
		System.out.println("enter price");
		double price = ConsoleReader.readLongByConsole();
		System.out.println("enter ending date");
		Date endingDate = ConsoleReader.readDateByConsole();
		System.out.println("enter start working on date");
		Date startDate = ConsoleReader.readDateByConsole();
		Order Order = new Order(price, endingDate, startDate);
		controller.addOrder(Order);
		UIObservable.getInstance()
				.notifyAllObservers(String.format("order id: %s successfully created", Order.getId()));

	}

}
