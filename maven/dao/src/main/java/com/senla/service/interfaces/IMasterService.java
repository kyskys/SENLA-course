package com.senla.service.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;

public interface IMasterService extends ISortableService<Master> {

	public Order getOrderExecutingByConcreteMaster(Long id) throws SQLException;

	public List<Master> getFreeMastersOnDate(Date date) throws SQLException;

	public void addOrderToMaster(Long idOrder, Long idMaster) throws SQLException;

	public void removeOrderFromMaster(Long idMaster) throws SQLException;
}
