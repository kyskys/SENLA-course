package storage;

import entities.BaseEntity;

public interface IStorage {
	boolean add(BaseEntity be);

	boolean remove(BaseEntity be);

}
