package action.order;

import action.Action;
import controller.IController;
import observer.UIObservable;
import util.ConsoleReader;

public class DeleteOrder implements Action {

	@Override
	public void doAction(IController controller) {
		controller.showOrders();
		System.out.println("type id of rrder");
		long idOrder = ConsoleReader.readLongByConsole();
		try {
			controller.removeOrder(idOrder);
			UIObservable.getInstance().notifyAllObservers(String.format("order id: %s successully deleted", idOrder));
			}
		catch(EntityNotFoundException e) {//ne pomnu kak nazivaetsa
			throw new MyException(ExceptionEnum.EntityException);
		}
		
	}


}
