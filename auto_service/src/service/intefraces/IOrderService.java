package service.intefraces;

import java.util.Date;

import entities.Order;

public interface IOrderService extends ISortableService<Order> {
	public void setOrderCancelled(Long id);

	public void setOrderClosed(Long id);

	public void shiftOrderExecutionTime(int days);

	public String showOrders(String parameter);

	public String showExecutingOrders(String parameter);

	public String showMastersExecutingConcreteOrder(Long id);

	public String showOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter);

	public String showNearestDate();
}
