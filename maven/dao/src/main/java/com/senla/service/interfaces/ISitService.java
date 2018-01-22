package com.senla.service.interfaces;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Sit;
import com.senla.service.interfaces.IAbstractService;

public interface ISitService extends IAbstractService<Sit> {
	public List<Sit> getFreeSits();

	public List<Sit> getFreeSitsAtDate(Date date);

	public void addOrderToSit(Long idOrder, Long idSit);

	public void removeOrderFromSit(Long idSit);

	public void addGarageToSit(Long idGarage, Long idSit);

	public void removeGarageFromSit(Long idGarage, Long idSit);
}
