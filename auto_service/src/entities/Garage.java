package entities;

import java.util.ArrayList;
import java.util.List;

public class Garage extends BaseEntity {

	private static final long serialVersionUID = -7398169700892165167L;
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
	public String toString() {
		return String.format("id: %s, sits: %s", id, sits);
	}
}
