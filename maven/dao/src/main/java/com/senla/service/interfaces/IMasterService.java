package com.senla.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;

public interface IMasterService extends ISortableService<Master> {

	public Order getOrderExecutingByConcreteMaster(Long id) throws Throwable;

	public List<Master> getFreeMastersOnDate(Date date) throws Throwable;

	public void addOrderToMaster(Long idOrder, Long idMaster) throws Throwable;

	public void removeOrderFromMaster(Long idMaster) throws Throwable;
}
