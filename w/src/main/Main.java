package main;

import airport.*;
import entity.*;

public class Main {

	public static void main(String[] args) {
		Airport a = new Airport(10);
		Flight f = new Flight("flight1",10);
		a.add(f);
		Passenger p = new Passenger("bob","passport123");
		a.show();
		a.addPassengerToFlight(p, f);
		a.show();
		f.setCancelled(true);
		a.show();
	}

}
