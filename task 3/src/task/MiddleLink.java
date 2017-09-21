package task;

public class MiddleLink extends Employee {
	protected String industry;

	public MiddleLink(String name, int salary) {
		super(name, salary);
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
}
