package entity;

public class Flight extends AEntity{
	private Passenger[] passengers;
	private int maxSits;
	private boolean isCancelled;
	private boolean isLate;
	public Passenger[] getPassengers() {
		return passengers;
	}
	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}
	public int getMaxSits() {
		return maxSits;
	}
	public void setMaxSits(int maxSits) {
		this.maxSits = maxSits;
	}
	public boolean isCancelled() {
		return isCancelled;
	}
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	public boolean isLate() {
		return isLate;
	}
	public void setLate(boolean isLate) {
		this.isLate = isLate;
	}
}
