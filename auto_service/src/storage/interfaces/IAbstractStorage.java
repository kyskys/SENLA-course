package storage.interfaces;

import entities.BaseEntity;

public interface IAbstractStorage<T extends BaseEntity> {
	boolean create(T Entity);
	boolean delete(T entity);
	
}
