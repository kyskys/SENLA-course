package entity;

import util.Helper;

public class Flight extends AEntity {

	private Passenger[] passengers;
	private int maxSits;
	private boolean cancelled;
	private boolean late;
	private String direction;

	public Flight(String flightNumber, String direction, int sits) {
		super(flightNumber);
		this.maxSits = sits;
		this.direction=direction;
		passengers = new Passenger[sits];
	}

	public Passenger[] getPassengers() {
		return passengers;
	}

	public void addPassenger(Passenger passenger) {
		int i = Helper.searchEmpty(passengers);
		if (i != -1) {
			passengers[i] = passenger;
			maxSits--;
		} else {
			System.out.println("error: no sits");
		}
	}

	public void removePassenger(String passportNumber) {
		int i = Helper.searchEntity(passengers, passportNumber);
		if (i != -1) {
			passengers[i] = null;
			maxSits++;
		} else {
			System.out.println("error: no such passenger");
		}
	}

	public int getMaxSits() {
		return maxSits;
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

	public String getDirection() {
		return direction;
	}

}
