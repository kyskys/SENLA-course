package data;

import com.senla.entities.Order;
import com.senla.service.interfaces.IOrderService;
import com.senla.util.Utils;

import annotation.Injectable;

public class OrderSCVManager extends AbstractCSVManager<Order> implements ISCVManager<Order> {
	@Injectable
	private IOrderService orderService;

	@Override
	public void importSCV(String data) {
		String[] currentOrderData = data.split(" ");
		Long idOrder = Long.valueOf(currentOrderData[0]);
		Order order;
		if (orderService.get(idOrder) == null) {
			order = new Order(idOrder, null, null);
			order.setId(idOrder);
			orderService.create(order);
		} else {
			order = orderService.get(idOrder);
		}
		order.setAddedDate(Utils.convertStringToDate(currentOrderData[2]));
		order.setStartWorkingOnDate(Utils.convertStringToDate(currentOrderData[3]));
		order.setClosed(Boolean.getBoolean(currentOrderData[5]));
		order.setCancelled(Boolean.getBoolean(currentOrderData[6]));
		if (currentOrderData[7] != null) {
			String[] orderMasters = currentOrderData[7].split(",");
			for (String m : orderMasters) {
				orderService.addMasterToOrder(Long.valueOf(m), idOrder);
			}
		}
	}

	@Override
	public String[] exportSCV() {
		return getListAsArray(orderService.getAll());
	}

	@Override
	public String convertEntityToCSVString(Order entity) {
		return String.format("%s %s %s %s %s %s %s %s", entity.getId(), entity.getPrice(), entity.getAddedDate(),
				entity.getStartWorkingOnDate(), entity.getEndingDate(), entity.isClosed(), entity.isCancelled(),
				convertListToCSVString(entity.getMasters()));
	}
}