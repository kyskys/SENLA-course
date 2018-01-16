package com.senla.storage.interfaces;

import com.senla.entities.BaseEntity;
import com.senla.util.SortParameters;

public interface ISortableStorage<T extends BaseEntity> extends IAbstractStorage<T> {
	 String convertToFieldName(SortParameters parameter);
}
