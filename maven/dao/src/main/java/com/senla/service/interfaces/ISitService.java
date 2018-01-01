package com.senla.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Sit;
import com.senla.service.interfaces.IAbstractService;

public interface ISitService extends IAbstractService<Sit> {
	public List<Sit> getFreeSits() throws Throwable;

	public List<Sit> getFreeSitsAtDate(Date date) throws Throwable;

	public void addOrderToSit(Long idOrder, Long idSit) throws Throwable;

	public void removeOrderFromSit(Long idSit) throws Throwable;
	
	public void addGarageToSit(Long idGarage, Long idSit) throws Throwable;
	
	public void removeGarageFromSit(Long idGarage, Long idSit) throws Throwable;
}
