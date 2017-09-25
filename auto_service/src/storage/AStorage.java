package storage;

import java.util.ArrayList;
import java.util.List;

import entities.BaseEntity;

public abstract class AStorage<T extends BaseEntity> {
	List<T> list = new ArrayList<T>();

	public boolean add(T entity) {
		return list.add(entity);
	}

	public boolean remove(T entity) {
		return list.remove(entity);
	}

	public List<T> getList() {
		return list;
	}
}
