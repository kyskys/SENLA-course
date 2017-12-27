package com.senla.service.interfaces;

import java.util.List;

import com.senla.entities.BaseEntity;
import com.senla.util.SortParameters;

public interface ISortableService<T extends BaseEntity> extends IAbstractService<T> {
	public List<T> getAll(SortParameters parameter);
}
