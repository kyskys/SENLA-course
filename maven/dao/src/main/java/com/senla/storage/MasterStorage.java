package com.senla.storage;

import java.sql.SQLException;

import com.senla.entities.Master;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.IMasterStorage;

public class MasterStorage extends SortableStorage<Master> implements IMasterStorage {

	@Override
	public Class<Master> getGenericClass() {
		return Master.class;
	}

	@Override
	public String convertToFieldName(SortParameters parameter) throws SQLException {
		switch (parameter) {
		case ALPHABET: {
			return "name";
		}
		case BUSY: {
			return "busy";
		}
		default:
			return "master_id";
		}
	}
}
