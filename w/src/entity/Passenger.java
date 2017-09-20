package entity;

public class Passenger extends AEntity{
	public Passenger(String name, String passport) {
		super(name);
		this.passport=passport;
	}

	private String passport;

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
	
}
