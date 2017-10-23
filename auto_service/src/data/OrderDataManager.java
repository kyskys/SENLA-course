package data;

import entities.Order;
import util.Utils;

public class OrderDataManager extends AbstractDataManager<Order> {
	public OrderDataManager(String filePath) {
		super(filePath);
	}

	@Override
	public String convertEntityToString(Order entity) {
		return entity.getId() + " " + entity.getPrice() + " " + Utils.convertDateToString(entity.getAddedDate()) + " "
				+ Utils.convertDateToString(entity.getStartWorkingOnDate()) + " "
				+ Utils.convertDateToString(entity.getEndingDate()) + " " + entity.isClosed() + " "
				+ entity.isCancelled() + " " + ConvertListToString(entity.getMasters());
	}
}