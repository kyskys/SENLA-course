package main;

import airport.*;
import entity.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(String.format("%-10s %-20s %-10s %-10s %-10s", "number","direction","cancelled","lated","sits"));
		Airport a = new Airport(10);
		Flight f = new Flight("e1677","moscow-minsk",30);
		a.addFlight(f);
		Passenger p = new Passenger("KH1234567","bob");
		a.show();
		a.addPassengerToFlight(p, "e1677");
		a.show();
		a.setCancelled("e1677");
		a.show();
		a.removePassengerFromFlight("KH1234567", "e1677");
		a.show();
		a.setLate("e1677");
		a.show();
	}

}
