package com.senla.storage;

import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.senla.entities.Garage;
import com.senla.storage.interfaces.IGarageStorage;

@Service
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
