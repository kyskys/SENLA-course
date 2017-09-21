package task;

public abstract class Specialist extends Employee {

	protected String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Specialist(String name, int salary, String department) {
		super(name, salary);
	}

}
