package com.senla.storage.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.senla.entities.Master;

public interface IMasterStorage extends ISortableStorage<Master> {

	Long getMasterIdByOrderId(Long id) throws SQLException;
	
	List<Master> getFreeMastersOnDate(Date date) throws SQLException;
	
	List<Master> getMastersExecutingConcreteOrder(Long id) throws SQLException;
}
