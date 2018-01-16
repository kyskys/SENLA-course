package com.senla.service.interfaces;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.sort.SortParameters;

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

	public void removeMasterFromOrder(Long idMaster) throws SQLException;
	
	Order getOrderExecutingByConcreteMaster(Long id) throws SQLException;

}
