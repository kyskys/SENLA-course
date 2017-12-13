package com.senla.service;

import java.util.List;

import com.senla.entities.BaseEntity;
import com.senla.service.interfaces.IAbstractService;
import com.senla.storage.interfaces.IAbstractStorage;

public abstract class AbstractService<T extends BaseEntity> implements IAbstractService<T> {
	
	@Override
	public boolean create(T entity) {
		synchronized (getStorage()) {
			return getStorage().create(entity);
		}
	}

	@Override
	public boolean delete(Long id) {
		synchronized (getStorage()) {
			return getStorage().delete(id);
		}
	}

	@Override
	public T get(Long id) {
		return getStorage().get(id);
	}

	@Override
	public List<T> getAll() {
		return getStorage().getAll();
	}

	abstract public IAbstractStorage<T> getStorage();

}
