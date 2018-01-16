package com.senla.service.interfaces;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;

public interface IMasterService extends ISortableService<Master> {

	public List<Master> getFreeMastersOnDate(Date date) throws SQLException;

	public void addOrderToMaster(Long idOrder, Long idMaster) throws SQLException;

	public void removeOrderFromMaster(Long idOrder, Long idMaster) throws SQLException;
}
