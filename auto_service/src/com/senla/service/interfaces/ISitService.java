package com.senla.service.interfaces;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.senla.entities.Sit;
import com.senla.service.interfaces.IAbstractService;

public interface ISitService extends IAbstractService<Sit> {
	public List<Sit> getFreeSits() throws SQLException;

	public List<Sit> getFreeSitsAtDate(Date date) throws SQLException;

	public void addOrderToSit(Long idOrder, Long idSit) throws SQLException;

	public void removeOrderFromSit(Long idSit) throws SQLException;
	
	public void addGarageToSit(Long idGarage, Long idSit) throws SQLException;
	
	public void removeGarageFromSit(Long idGarage, Long idSit) throws SQLException;
}
