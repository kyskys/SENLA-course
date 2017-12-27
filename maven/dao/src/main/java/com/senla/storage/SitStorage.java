package com.senla.storage;

import com.senla.entities.Sit;
import com.senla.storage.interfaces.ISitStorage;

public class SitStorage extends AbstractStorage<Sit> implements ISitStorage {

	@Override
	public Class<Sit> getGenericClass() {
		return Sit.class;
	}

}
