package com.senla.service.intefraces;

import java.util.List;

import com.senla.entities.BaseEntity;
import com.senla.sort.SortParameters;

public interface ISortableService<T extends BaseEntity> extends IAbstractService<T> {
	public List<T> getAll(SortParameters parameter);
}
