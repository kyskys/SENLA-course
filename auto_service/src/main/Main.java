package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Controller;
import controller.IController;
import entities.Garage;
import entities.Master;
import entities.Order;
import entities.Sit;

public class Main {

	public static void main(String[] args) throws ParseException {
		IController controller = new Controller();
		Garage garage = new Garage();
		Sit sit = new Sit(garage);
		Master master = new Master("nikita");
		Order order = new Order(15,new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2018"));
		order.addMaster(master);
		order.setStartWorkingOnDate(new SimpleDateFormat("dd.MM.yyyy").parse("06.06.2018"));
		garage.addSit(sit);
		master.setOrder(order);
		sit.setOrder(order);
		controller.addGarage(garage);
		controller.addMaster(master);
		controller.addOrder(order);
		controller.addSit(sit);
		Garage garage1 = new Garage();
		Sit sit1 = new Sit(garage);
		Master master1 = new Master("pasha");
		Order order1 = new Order(10,new SimpleDateFormat("dd.MM.yyyy").parse("12.12.2019"));
		order1.addMaster(master1);
		order1.setStartWorkingOnDate(new SimpleDateFormat("dd.MM.yyyy").parse("06.06.2019"));
		garage1.addSit(sit1);
		master1.setOrder(order1);
		sit1.setOrder(order1);
		controller.addGarage(garage1);
		controller.addMaster(master1);
		controller.addOrder(order1);
		controller.addSit(sit1);
		controller.showExecutingOrders("start date");
		controller.setOrderCancelled(3);
		controller.setOrderClosed(7);
		controller.showExecutingOrders("price");
		controller.showExecutingOrders("ending date");
		Garage garage2 = new Garage();
		Sit sit2 = new Sit(garage2);
		controller.addSit(sit2);
		controller.addGarage(garage2);
		controller.showFreeSits();
		
	}

}
