package entities;

import java.util.List;

public class Garage extends BaseEntity {
	public Garage(long id) {
		super(id);
	}
	private List<Sit> sits;

	public boolean addSit(Sit sit) {
		return sits.add(sit);
	}

	public boolean removeSit(Sit sit) {
		return sits.remove(sit);
	}
	public List<Sit> getSits() {
		return sits;
	}
}
