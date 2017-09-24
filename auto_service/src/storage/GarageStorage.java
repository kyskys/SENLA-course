package storage;

import java.util.ArrayList;
import java.util.List;

import entities.BaseEntity;
import entities.Garage;

public class GarageStorage implements IStorage {
	private List<Garage> garages = new ArrayList<Garage>();

	@Override
	public boolean add(BaseEntity be) {
		return garages.add((Garage) be);
	}

	@Override
	public boolean remove(BaseEntity be) {
		return garages.remove(be);
	}

}
