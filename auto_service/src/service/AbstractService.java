package service;

import java.util.List;

import entities.BaseEntity;
import service.intefraces.IAbstractService;
import storage.interfaces.IAbstractStorage;

public abstract class AbstractService<T extends BaseEntity> implements IAbstractService<T> {
	
	@Override
	public boolean create(T entity) {
		return getStorage().create(entity);
	}

	@Override
	public boolean delete(Long id) {
		return getStorage().delete(id);
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
