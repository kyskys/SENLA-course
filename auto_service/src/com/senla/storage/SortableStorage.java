package com.senla.storage;

import java.util.List;

import com.senla.entities.BaseEntity;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.ISortableStorage;

public abstract class SortableStorage<T extends BaseEntity> extends AbstractStorage<T> implements ISortableStorage<T> {
	protected abstract void sort(List<T> listToSort, SortParameters parameter);

	@Override
	public List<T> getAll(SortParameters parameter) {
		sort(list, parameter);
		return list;
	}
}
