package com.senla.service.interfaces;

import com.senla.entities.Garage;

public interface IGarageService extends IAbstractService<Garage> {
	public void addSitToGarage(Long idGarage, Long idSit) throws Throwable;

	public void removeSitFromGarage(Long idSit, Long idGarage) throws Throwable;
}
