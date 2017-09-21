package task;

public class Director extends Leadership{

	public Director(String name, int salary) {
		super(name, salary);
		subordinates=new Employee[100];
	}
	
	public void hireEmployee(Employee employee) {
		
	}
	
	public void layOffEmployee(Employee employee) {
		
	}
	
}
