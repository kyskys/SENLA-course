package storage;

import java.util.ArrayList;
import java.util.List;

import counter.Counter;
import entities.BaseEntity;
import storage.interfaces.IAbstractStorage;

public abstract class AbstractStorage<T extends BaseEntity> implements IAbstractStorage<T> {
	List<T> list = new ArrayList<T>();

	@Override
	public boolean create(T entity) {
		entity.setId(Counter.getId());
		return list.add(entity);
	}

	@Override
	public boolean delete(Long id) {
		return list.remove(get(id));
	}

	@Override
	public List<T> getAll() {
		return list;
	}

	@Override
	public T get(Long id) {
		for (T entity : list) {
			if (entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}
}
