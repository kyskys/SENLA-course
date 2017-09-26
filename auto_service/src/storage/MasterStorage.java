package storage;

import java.util.Comparator;
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
		default: return;
		}
		listToSort.sort(comparator);
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) {
		return get(id).getOrder();
	}
	
}
