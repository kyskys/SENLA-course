package com.senla.storage;

import java.sql.SQLException;
import java.util.List;

import com.senla.entities.BaseEntity;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.ISortableStorage;

public abstract class SortableStorage<T extends BaseEntity> extends AbstractStorage<T> implements ISortableStorage<T> {
	protected abstract String sort(SortParameters parameter) throws SQLException;
	
	public abstract List<T> getAll(SortParameters parameter) throws SQLException;
		
}
