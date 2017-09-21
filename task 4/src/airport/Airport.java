package airport;

import entity.Flight;
import entity.Passenger;
import util.Helper;

public class Airport {
	Flight[] flights;

	public Airport(int num) {
		flights = new Flight[num];
	}

	public void addFlight(Flight flight) {
		int i = Helper.searchEmpty(flights);
		if (i != -1) {
			flights[i] = flight;
		} else {
			System.out.println("error: limit of flight reached");
		}
	}

	public void addPassengerToFlight(Passenger passenger, String flightNumber) {
		int i = Helper.searchEntity(flights, flightNumber);
		if (i != -1) {
			flights[i].addPassenger(passenger);
		} else {
			System.out.println("error: no such flight");
		}
	}

	public void removePassengerFromFlight(String passengerNumber, String flightNumber) {
		int i = Helper.searchEntity(flights, flightNumber);
		if (i != -1) {
			flights[i].removePassenger(passengerNumber);
		} else {
			System.out.println("error: no such flight");
		}
	}

	public void show() {
		for (int i = 0; i < flights.length; i++) {
			if (flights[i] != null) {
				Flight f = (Flight) flights[i];
				System.out.println(String.format("%-10s %-20s %-10s %-10s %-10s",f.getNumber(),
						f.getDirection(), f.isCancelled(), f.isLate(), f.getFreeSits()));
			}
		}
	}

	public void setCancelled(String flightNumber) {
		int i = Helper.searchEntity(flights, flightNumber);
		if (i != -1) {
			flights[i].setCancelled(true);
			;
		} else {
			System.out.println("error: no such flight");
		}

	}

	public void setLate(String flightNumber) {
		int i = Helper.searchEntity(flights, flightNumber);
		if (i != -1) {
			flights[i].setLate(true);
			;
		} else {
			System.out.println("error: no such flight");
		}
	}
}
