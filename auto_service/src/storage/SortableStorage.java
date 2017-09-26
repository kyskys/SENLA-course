package storage;

import java.util.List;

import entities.BaseEntity;
import sort.SortParameters;

public abstract class SortableStorage<T extends BaseEntity> extends AbstractStorage<T>{
	protected abstract boolean sort(List<T> listToSort, SortParameters parameter);
}
