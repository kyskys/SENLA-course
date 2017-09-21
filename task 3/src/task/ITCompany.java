package task;

public class ITCompany {
	Employee[] employees;
	int count = 0;

	public ITCompany(int numberOfEmployees) {
		employees = new Employee[numberOfEmployees];
	}

	public void addEmployee(Employee employee) {
		employees[count] = employee;
		count++;
	}
	public long evaluateMonthSalary() {
		long result = 0;
		for(int i=0;i<count;i++) {	
				result+=employees[i].getSalary();
		}
		return result;
	}
}
