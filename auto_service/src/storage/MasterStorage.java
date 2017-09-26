package storage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Order;
import sort.SortMastersByAlphabet;
import sort.SortMastersByBusy;
import sort.SortParameters;
import storage.interfaces.IMasterStorage;

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
		listToSort.sort(comparator);
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
