package service.intefraces;

import java.util.List;

import entities.BaseEntity;
import sort.SortParameters;

public interface ISortableService<T extends BaseEntity> extends IAbstractService<T> {
	public List<T> getAll(SortParameters parameter);
}
