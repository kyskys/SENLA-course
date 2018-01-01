package com.senla.service.interfaces;

import java.util.List;

import com.senla.entities.BaseEntity;

public interface IAbstractService<T extends BaseEntity> {
	void create(T entity) throws Throwable;

	void delete(T entity) throws Throwable;

	void update(T entity) throws Throwable;

	T get(Long id) throws Throwable;

	List<T> getAll() throws Throwable;
}
