package airport;

import entity.Flight;
import entity.Passenger;
import util.Helper;

public class Airport {
	Flight[] flights;

	public Airport(int num) {
		flights = new Flight[num];
	}

	public void add(Flight e) {
		int i = Helper.searchEmpty(flights);
		if (i != -1) {
			flights[i] = e;
		} else
			System.out.println("error: limit of flight reached");
	}

	public void remove(Flight e) {
		int i = Helper.searchEntity(flights, e);
		if (i != -1) {
			flights[i] = null;
		} else
			System.out.println("error: no such entity");
	}

	public void addPassengerToFlight(Passenger p, Flight f) {
		int i = Helper.searchEntity(flights, f);
		if (i != -1) {
			flights[i].addPassenger(p);
		} else
			System.out.println("error: no sits");
	}

	public void show() {
		for (int i = 0; i < flights.length; i++) {
			if (flights[i] != null) {
				Flight f = (Flight) flights[i];
				System.out.println(
						i + " " + f.getName() + " " + f.isCancelled() + " " + f.isLate() + " " + f.getMaxSits());
			}
		}
	}

	public void setCancelled(Flight e) {
		e.setCancelled(true);
	}

	public void setLate(Flight e) {
		e.setLate(true);
	}
}
