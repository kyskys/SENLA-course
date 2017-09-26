package storage.interfaces;

import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Order;
import sort.SortParameters;

public interface IOrderStorage extends IAbstractStorage<Order> {
	List<Master> getMastersExecutingConcreteOrder(Long id);

	List<Order> getExecutingOrders(SortParameters parameter);

	List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter);

	void setOrderCancelled(Long id);

	void setOrderClosed(Long id);
}
