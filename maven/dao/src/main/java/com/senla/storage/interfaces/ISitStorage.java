package com.senla.storage.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.senla.entities.Sit;

public interface ISitStorage extends IAbstractStorage<Sit> {
	public List<Sit> getFreeSits(EntityManager manager) throws SQLException;

	public List<Sit> getFreeSitsAtDate(EntityManager manager, Date date) throws SQLException;
}
