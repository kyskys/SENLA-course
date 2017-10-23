package com.senla.storage.interfaces;

import java.util.Date;
import java.util.List;

import com.senla.entities.Sit;

public interface ISitStorage extends IAbstractStorage<Sit> {
	List<Sit> getFreeSitsOnDate(Date date);

}
