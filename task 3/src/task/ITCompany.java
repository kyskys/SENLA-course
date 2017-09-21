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
	public double evaluateAverageSalary() {
		double average = 0;
		for(int i=0;i<count;i++) {	
				average+=employees[i].getSalary();
		}
		average=average/count;
		return average;
	}
}
