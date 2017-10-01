package main;

import java.text.ParseException;

import controller.Controller;
import controller.IController;
import entities.Garage;
import entities.Master;
import entities.Order;
import entities.Sit;
import file_manager.FileManager;
import util.Utils;

public class Main {

	public static void main(String[] args) throws ParseException {
		IController controller = new Controller();
		FileManager fm = new FileManager();
		fm.load();
		Garage garage = new Garage();
		Sit sit = new Sit(garage);
		Master master = new Master("nikita");
		Order order = new Order(15, Utils.convertStringToDate("12.12.2018"));
		order.addMaster(master);
		order.setStartWorkingOnDate(Utils.convertStringToDate("06.06.2018"));
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
		Master master2 = new Master("kolya");
		Order order1 = new Order(10, Utils.convertStringToDate("12.12.2019"));
		order1.addMaster(master1);
		order1.addMaster(master2);
		order1.setStartWorkingOnDate(Utils.convertStringToDate("06.06.2019"));
		garage1.addSit(sit1);
		master1.setOrder(order1);
		master2.setOrder(order1);
		sit1.setOrder(order1);
		controller.addGarage(garage1);
		controller.addMaster(master1);
		controller.addMaster(master2);
		controller.addOrder(order1);
		controller.addSit(sit1);
		controller.showExecutingOrders("start date");
		controller.setOrderCancelled(3);
		controller.setOrderClosed(8);
		controller.showOrders("price");
		controller.showOrders("ending date");
		Garage garage2 = new Garage();
		Sit sit2 = new Sit(garage2);
		controller.addSit(sit2);
		controller.addGarage(garage2);
		Master master3 = new Master("vasya");
		controller.addMaster(master3);
		controller.showMasters();
		controller.showFreeSits();
		controller.showFreeSitsAtDate(Utils.convertStringToDate("06.06.2020"));
		controller.showMastersExecutingConcreteOrder(3);
		controller.showOrderExecutingByConcreteMaster(2);
		controller.showOrdersForPeriodOfTime(Utils.convertStringToDate("06.06.2019"), Utils.convertStringToDate("06.06.2017"), "price");
		fm.save();
	}
}
