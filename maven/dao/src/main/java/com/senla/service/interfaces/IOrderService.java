package com.senla.service.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.util.SortParameters;

public interface IOrderService extends ISortableService<Order> {
	public void setOrderCancelled(Long id, Boolean value) throws SQLException;

	public void setOrderClosed(Long id, Boolean value) throws SQLException;

	public void shiftOrderExecutionTime(int days) throws SQLException;

	public List<Order> getExecutingOrders(SortParameters parameter) throws SQLException;

	public List<Master> getMastersExecutingConcreteOrder(Long id) throws SQLException;

	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter)
			throws SQLException;

	public Date getNearestDate() throws SQLException;

	public void addMasterToOrder(Long idMaster, Long idOrder) throws SQLException;

	public void removeMasterFromOrder(Long idMaster, Long idOrder) throws SQLException;

}
