package storage.interfaces;

import java.util.List;

import entities.BaseEntity;
import sort.SortParameters;

public interface ISortableStorage<T extends BaseEntity> extends IAbstractStorage<T> {
	public List<T> getAll(SortParameters parameter);
}
