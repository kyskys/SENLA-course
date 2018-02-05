package com.senla.storage.interfaces;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.senla.entities.BaseEntity;
import com.senla.util.SortParameters;

public interface ISortableStorage<T extends BaseEntity> extends IAbstractStorage<T> {

	List<T> getAll(EntityManager manager, SortParameters parameter) throws SQLException;
}
