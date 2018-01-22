package com.senla.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;

public interface IMasterService extends ISortableService<Master> {

	public Order getOrderExecutingByConcreteMaster(Long id);

	public List<Master> getFreeMastersOnDate(Date date);

	public void addOrderToMaster(Long idOrder, Long idMaster);

	public void removeOrderFromMaster(Long idMaster);
}
