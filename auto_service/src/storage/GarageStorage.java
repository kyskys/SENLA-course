package storage;

import java.util.ArrayList;
import java.util.List;

import entities.BaseEntity;
import entities.Sit;

public class GarageStorage implements IStorage {
	private List<Sit> sits = new ArrayList<Sit>();

	@Override
	public boolean add(BaseEntity be) {
		return sits.add((Sit) be);
	}

	@Override
	public boolean remove(BaseEntity be) {
		return sits.remove(be);
	}

}
