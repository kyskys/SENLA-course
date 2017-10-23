package com.senla.storage.interfaces;

import java.util.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.sort.SortParameters;

public interface IOrderStorage extends ISortableStorage<Order> {
	List<Master> getMastersExecutingConcreteOrder(Long id);

	List<Order> getExecutingOrders(SortParameters parameter);

	List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter);

	void setOrderCancelled(Long id);

	void setOrderClosed(Long id);

	Date showNearestDate();
}
