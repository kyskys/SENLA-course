package com.senla.storage.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.senla.entities.Master;
import com.senla.entities.Order;

public interface IMasterStorage extends ISortableStorage<Master> {
	public Order getOrderExecutingByConcreteMaster(EntityManager manager, Long id) throws SQLException;

	public List<Master> getFreeMastersOnDate(EntityManager manager, Date date) throws SQLException;
}
