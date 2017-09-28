package service;

import java.util.List;

import entities.BaseEntity;
import service.intefraces.ISortableService;
import sort.SortParameters;
import storage.interfaces.ISortableStorage;

public abstract class SortableService<T extends BaseEntity> extends AbstractService<T> implements ISortableService<T> {

	public List<T> getAll(SortParameters parameter) {
		return getStorage().getAll(parameter);
	}

	@Override
	public abstract ISortableStorage<T> getStorage();
}
