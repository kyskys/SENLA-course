package com.senla.storage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.senla.entities.BaseEntity;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.ISortableStorage;

public abstract class SortableStorage<T extends BaseEntity> extends AbstractStorage<T> implements ISortableStorage<T> {
	
	static Map<SortParameters, String> sortValues;
	static {
		sortValues = new HashMap<SortParameters, String>();
		sortValues.put(SortParameters.ALPHABET, "name");
		sortValues.put(SortParameters.ADDED_DATE, "addedDate");
		sortValues.put(SortParameters.ENDING_DATE, "endingDate");
		sortValues.put(SortParameters.START_WORKING_ON_DATE, "startWorkingOnDate");
		sortValues.put(SortParameters.BUSY, "busy");
		sortValues.put(SortParameters.PRICE, "price");
	}
	
	public String sort(SortParameters parameter) {
		String result = sortValues.get(parameter);
		return result != null ? result : "id";
	}
	
	public abstract List<T> getAll(SortParameters parameter) throws SQLException;
		
}
