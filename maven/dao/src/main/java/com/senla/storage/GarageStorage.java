package com.senla.storage;

import javax.persistence.criteria.Root;

import com.senla.entities.Garage;
import com.senla.storage.interfaces.IGarageStorage;

public class GarageStorage extends AbstractStorage<Garage> implements IGarageStorage {

	@Override
	public Class<Garage> getGenericClass() {
		return Garage.class;
	}

	@Override
	protected void joinLazyFields(Root<?> root) {
		root.fetch("sits");
	}

}
