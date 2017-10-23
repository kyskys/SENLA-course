package com.senla.storage.interfaces;

import java.util.List;

import com.senla.entities.BaseEntity;

public interface IAbstractStorage<T extends BaseEntity> {
	boolean create(T Entity);
	boolean delete(Long id);
	T get(Long id);
	List<T> getAll();
}
