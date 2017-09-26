package storage.interfaces;

import java.util.Date;
import java.util.List;

import entities.Sit;

public interface ISitStorage extends IAbstractStorage<Sit> {
	List<Sit> getFreeSitsOnDate(Date date);

}
