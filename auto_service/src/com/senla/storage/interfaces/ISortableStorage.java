package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.senla.entities.BaseEntity;
import com.senla.sort.SortParameters;

public interface ISortableStorage<T extends BaseEntity> extends IAbstractStorage<T> {
	public List<T> getAll(SortParameters parameter) throws SQLException;
}
