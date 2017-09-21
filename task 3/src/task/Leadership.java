package task;

public class Leadership extends Employee {

	protected Employee[] subordinates;

	public Leadership(String name, int salary) {
		super(name, salary);
	}

	public Employee[] getSubordinates() {
		return subordinates;
	}
}
