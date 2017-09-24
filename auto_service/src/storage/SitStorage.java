package storage;

import java.util.ArrayList;
import java.util.List;

import entities.BaseEntity;
import entities.Sit;

public class SitStorage implements IStorage {
	private List<Sit> sits = new ArrayList<Sit>();

	@Override
	public boolean add(BaseEntity be) {
		return sits.add((Sit) be);
	}

	@Override
	public boolean remove(BaseEntity be) {
		return sits.remove(be);
	}

	public List<Sit> getSits() {
		return sits;
	}
	public void showAvailableSits() {
		int availableSits = 0;
		for (int i = 0; i < sits.size(); i++) {
			if (sits.get(i).getOrder().equals(null)) {
				availableSits++;
			}
		}

		System.out.println("in garages available sits: "+availableSits);
	}
}
