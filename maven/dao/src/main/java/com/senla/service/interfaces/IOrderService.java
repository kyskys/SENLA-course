package com.senla.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.util.SortParameters;

public interface IOrderService extends ISortableService<Order> {
	public void setOrderCancelled(Long id, Boolean value) throws Throwable;

	public void setOrderClosed(Long id, Boolean value) throws Throwable;

	public void shiftOrderExecutionTime(int days) throws Throwable;

	public List<Order> getExecutingOrders(SortParameters parameter) throws Throwable;

	public List<Master> getMastersExecutingConcreteOrder(Long id) throws Throwable;

	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter)
			throws Throwable;

	public Date getNearestDate() throws Throwable;

	public void addMasterToOrder(Long idMaster, Long idOrder) throws Throwable;

	public void removeMasterFromOrder(Long idMaster, Long idOrder) throws Throwable;

}
