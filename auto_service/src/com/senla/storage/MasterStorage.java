package com.senla.storage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.sort.SortMastersByAlphabet;
import com.senla.sort.SortMastersByBusy;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.util.Utils;

public class MasterStorage extends SortableStorage<Master> implements IMasterStorage {

	@Override
	protected void sort(List<Master> listToSort, SortParameters parameter) {
		Comparator<Master> comparator = null;
		switch (parameter) {
		case ALPHABET: {
			comparator = new SortMastersByAlphabet();
			break;
		}
		case BUSY: {
			comparator = new SortMastersByBusy();
			break;
		}
		default:
			return;
		}
		listToSort.sort(Utils.nullSafeCompare(comparator));
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) {
		return get(id).getOrder();
	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) {
		List<Master> result = new ArrayList<Master>();
		for (int i = 0; i < list.size(); i++) {
			Master master = list.get(i);
			if (master.getOrder().getEndingDate().before(date)) {
				result.add(master);
			}
		}
		return result;
	}

}
