package storage;

import java.util.List;

import entities.BaseEntity;
import sort.SortParameters;
import storage.interfaces.ISortableStorage;

public abstract class SortableStorage<T extends BaseEntity> extends AbstractStorage<T> implements ISortableStorage<T> {
	protected abstract void sort(List<T> listToSort, SortParameters parameter);

	@Override
	public List<T> getAll(SortParameters parameter) {
		sort(list, parameter);
		return list;
	}
}
