package entities;

import java.util.ArrayList;
import java.util.List;

public class Garage extends BaseEntity {

	private List<Sit> sits;

	public Garage() {
		sits = new ArrayList<Sit>();
	}

	public boolean addSit(Sit sit) {
		return sits.add(sit);
	}

	public boolean removeSit(Sit sit) {
		return sits.remove(sit);
	}

	public List<Sit> getSits() {
		return sits;
	}

	@Override
	public String getAsString() {
		return "id: " + id + "sits: " + sits.toString();
	}
}
