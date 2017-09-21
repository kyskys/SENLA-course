package task;

public class Leadership extends Employee{
	public Leadership(String name, int salary) {
		super(name, salary);
	}
	protected Employee[] subordinates;
	
	public Employee[] getSubordinates() {
		return subordinates;
	}
}
