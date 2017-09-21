package task;

public class MiddleLink extends Employee {
	String industry;

	public MiddleLink(String name, int salary, String industry) {
		super(name, salary);
		this.industry=industry;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
}
