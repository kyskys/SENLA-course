package com.senla.service.intefraces;

import com.senla.entities.Garage;

public interface IGarageService extends IAbstractService<Garage> {
	public void addSitToGarage(Long idGarage);

	public void removeSitFromGarage(Long idSit, Long idGarage);
}
