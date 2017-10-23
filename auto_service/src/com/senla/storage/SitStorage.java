package com.senla.storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.storage.interfaces.ISitStorage;

public class SitStorage extends AbstractStorage<Sit> implements ISitStorage {

	@Override
	public List<Sit> getFreeSitsOnDate(Date date) {
		List<Sit> result = new ArrayList<Sit>();
		for (int i = 0; i < list.size(); i++) {
			Order order = list.get(i).getOrder();
			if (order == null) {
				result.add(list.get(i));
			} else if (order.getEndingDate().before(date)) {
				result.add(list.get(i));
			}
		}
		return result;
	}

}
