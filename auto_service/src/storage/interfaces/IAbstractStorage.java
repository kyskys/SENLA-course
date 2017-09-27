package storage.interfaces;

import java.util.List;

import entities.BaseEntity;

public interface IAbstractStorage<T extends BaseEntity> {
	boolean create(T Entity);
	boolean delete(Long id);
	T get(Long id);
	List<T> getAll();
}
