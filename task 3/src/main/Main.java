package main;

import task.CustomerRelationsManager;
import task.Director;
import task.ITCompany;
import task.ITmanager;
import task.MainProgrammer;
import task.ProjectManager;
import task.SystemAdministrator;

public class Main {

	public static void main(String[] args) {
		ITCompany company = new ITCompany(50);
		company.addEmployee(new CustomerRelationsManager("bob", 300));
		company.addEmployee(new Director("frodo", 2000));
		company.addEmployee(new ITmanager("alex", 270));
		company.addEmployee(new MainProgrammer("lucy", 500,"department"));
		company.addEmployee(new SystemAdministrator("nick", 610,"department"));
		company.addEmployee(new ProjectManager("alfred", 780));
		System.out.println(company.evaluateMonthSalary());
	}

}
