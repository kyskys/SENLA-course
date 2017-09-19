package main;

import entity.*;
import storage.*;

public class Main {

	public static void main(String[] args) {
		AStorage flights = new FlightStorage(10);
		AStorage passengers = new PassengerStorage(10);
		flights.add(new Flight());
		passengers.add(new Passenger());
		((FlightStorage) flights).show();
	}

}
