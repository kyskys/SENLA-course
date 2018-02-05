package com.senla.service;

import java.util.List;

import com.senla.entities.BaseEntity;
import com.senla.service.interfaces.ISortableService;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.ISortableStorage;

public abstract class SortableService<T extends BaseEntity> extends AbstractService<T> implements ISortableService<T> {

	public List<T> getAll(SortParameters parameter) {
		return executeAction(manager -> getStorage().getAll(manager, parameter));
	}

	@Override
	public abstract ISortableStorage<T> getStorage();
}
