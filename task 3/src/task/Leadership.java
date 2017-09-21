package task;

public class Leadership extends Employee {

	protected Employee[] subordinates;

	public Leadership(String name, int salary, Employee[] subordinates) {
		super(name, salary);
		this.subordinates = subordinates;
	}

	public Employee[] getSubordinates() {
		return subordinates;
	}
}
