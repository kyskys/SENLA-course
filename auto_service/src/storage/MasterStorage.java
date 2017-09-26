package storage;

import java.util.List;

import entities.Master;
import sort.SortMastersByAlphabet;
import sort.SortMastersByBusy;
import sort.SortParameters;

public class MasterStorage extends SortableStorage<Master> {

	@Override
	protected boolean sort(List<Master> listToSort, SortParameters parameter) {
		switch (parameter) {
		case ALPHABET: {
			listToSort.sort(new SortMastersByAlphabet());
			break;
		}
		case BUSY: {
			listToSort.sort(new SortMastersByBusy());
			break;
		}
		default:
			return false;
		}
		return true;
	}
}
