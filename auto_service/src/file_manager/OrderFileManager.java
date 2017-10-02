package file_manager;

import entities.Order;
import util.Utils;

public class OrderFileManager extends AbstractFileManager<Order> {
	public OrderFileManager(String filePath) {
		super(filePath);
	}

	@Override
	public String ConvertEntityToString(Order entity) {
		return entity.getId() + " " + entity.getPrice() + " " + Utils.convertDateToString(entity.getAddedDate()) + " "
				+ Utils.convertDateToString(entity.getStartWorkingOnDate()) + " " + Utils.convertDateToString(entity.getEndingDate())
				+ " " + entity.isClosed() + " " + entity.isCancelled() + " " + ConvertListToString(entity.getMasters());
	}
}
