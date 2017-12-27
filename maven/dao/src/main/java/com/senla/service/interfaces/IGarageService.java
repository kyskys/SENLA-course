package com.senla.service.interfaces;

import java.sql.SQLException;

import com.senla.entities.Garage;

public interface IGarageService extends IAbstractService<Garage> {
	public void addSitToGarage(Long idGarage, Long idSit) throws SQLException;

	public void removeSitFromGarage(Long idSit, Long idGarage) throws SQLException;
}
