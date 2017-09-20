package entity;

import util.Helper;

public class Flight extends AEntity {
	public Flight(String name, int sits) {
		super(name);
		this.maxSits = sits;
		passengers = new Passenger[sits];
	}

	private Passenger[] passengers;
	private int maxSits;
	private boolean cancelled;
	private boolean late;

	public Passenger[] getPassengers() {
		return passengers;
	}

	public void addPassenger(Passenger passenger) {
		int i = Helper.searchEmpty(passengers);
		if (i!=-1) {
			passengers[i]=passenger;
			maxSits--;
		}
		else System.out.println("error: no sits");
	}

	public int getMaxSits() {
		return maxSits;
	}

	public void setMaxSits(int maxSits) {
		this.maxSits = maxSits;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isLate() {
		return late;
	}

	public void setLate(boolean late) {
		this.late = late;
	}
}
