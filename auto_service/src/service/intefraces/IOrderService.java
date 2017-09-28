package service.intefraces;

import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Order;
import sort.SortParameters;

public interface IOrderService extends ISortableService<Order> {
	public void setOrderCancelled(Long id);

	public void setOrderClosed(Long id);

	public void shiftOrderExecutionTime(int days);

	public List<Order> getExecutingOrders(SortParameters parameter);

	public List<Master> getMastersExecutingConcreteOrder(Long id);

	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter);

	public Date getNearestDate();
}
