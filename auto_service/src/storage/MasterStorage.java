package storage;

import java.util.ArrayList;
import java.util.List;

import entities.BaseEntity;
import entities.Master;
import sort.SortParameters;

public class MasterStorage implements IStorage, Sortable {
	private List<Master> masters = new ArrayList<Master>();

	@Override
	public boolean sort(SortParameters sp) {
		boolean b = true;
		switch (sp) {
		case ALPHABET: {

			break;
		}
		case BUSY: {
			break;
		}
		default:
			b = false;
			break;
		}
		return b;
	}

	@Override
	public boolean add(BaseEntity be) {
		return masters.add((Master) be);
	}

	@Override
	public boolean remove(BaseEntity be) {
		return masters.remove(be);
	}

	public List<Master> getMasters() {
		return masters;
	}

}
