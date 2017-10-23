package com.senla.service.intefraces;

import java.util.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.sort.SortParameters;

public interface IOrderService extends ISortableService<Order> {
	public void setOrderCancelled(Long id);

	public void setOrderClosed(Long id);

	public void shiftOrderExecutionTime(int days);

	public List<Order> getExecutingOrders(SortParameters parameter);

	public List<Master> getMastersExecutingConcreteOrder(Long id);

	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter);

	public Date getNearestDate();

	public void addMasterToOrder(Long idMaster, Long idOrder);

	public void removeMasterFromOrder(Long idMaster, Long idOrder);

}
