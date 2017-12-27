package com.senla.storage;

import java.sql.SQLException;
import java.util.List;

import com.senla.entities.Master;
import com.senla.util.SortParameters;
import com.senla.storage.interfaces.IMasterStorage;

public class MasterStorage extends SortableStorage<Master> implements IMasterStorage {

	@Override
	public Class<Master> getGenericClass() {
		return Master.class;
	}
	
	@Override
	protected String sort(SortParameters parameter) throws SQLException {
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

	@Override
	public List<Master> getAll(SortParameters parameter) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
