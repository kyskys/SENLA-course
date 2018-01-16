package com.senla.storage.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.senla.entities.Sit;

public interface ISitStorage extends IAbstractStorage<Sit> {

	List<Sit> getGarageSits(Long id) throws SQLException;

	List<Sit> getFreeSits() throws SQLException;

	List<Sit> getFreeSits(Date date) throws SQLException;
}
