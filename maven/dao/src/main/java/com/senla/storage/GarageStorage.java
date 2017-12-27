package com.senla.storage;

import com.senla.entities.Garage;
import com.senla.storage.interfaces.IGarageStorage;

public class GarageStorage extends AbstractStorage<Garage> implements IGarageStorage {

	@Override
	public Class<Garage> getGenericClass() {
		return Garage.class;
	}

}
