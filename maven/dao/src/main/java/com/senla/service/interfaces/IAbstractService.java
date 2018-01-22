package com.senla.service.interfaces;

import java.util.List;

import com.senla.entities.BaseEntity;

public interface IAbstractService<T extends BaseEntity> {
	void create(T entity);

	void delete(T entity);

	void update(T entity);

	T get(Long id);

	List<T> getAll();
}
