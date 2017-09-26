package storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Sit;
import storage.interfaces.ISitStorage;

public class SitStorage extends AbstractStorage<Sit> implements ISitStorage {

	@Override
	public List<Sit> getFreeSitsOnDate(Date date) {
		List<Sit> result = new ArrayList<Sit>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOrder().getEndingDate().before(date)) {
				result.add(list.get(i));
			}
		}
		return result;
	}

}
