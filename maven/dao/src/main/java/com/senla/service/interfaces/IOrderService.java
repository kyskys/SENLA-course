package com.senla.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.util.SortParameters;

public interface IOrderService extends ISortableService<Order> {
	public void setOrderCancelled(Long id, Boolean value);

	public void setOrderClosed(Long id, Boolean value);

	public void shiftOrderExecutionTime(int days);

	public List<Order> getExecutingOrders(SortParameters parameter);

	public List<Master> getMastersExecutingConcreteOrder(Long id);

	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter);

	public Date getNearestDate();

	public void addMasterToOrder(Long idMaster, Long idOrder);

	public void removeMasterFromOrder(Long idMaster, Long idOrder);

}
