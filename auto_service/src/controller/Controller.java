package controller;

import java.util.Date;

import entities.Garage;
import entities.Master;
import entities.Order;
import entities.Sit;
import service.*;
import service.intefraces.*;

public class Controller implements IController {
	IGarageService garageService = new GarageService();
	IMasterService masterService = new MasterService();
	IOrderService orderService = new OrderService();
	ISitService sitService = new SitService();

	@Override
	public void addMaster(Master master) {
		masterService.create(master);
	}

	@Override
	public void removeMaster(long id) {
		masterService.delete(id);
	}

	@Override
	public void addOrder(Order order) {
		orderService.create(order);
	}

	@Override
	public void removeOrder(long id) {
		orderService.delete(id);
	}

	@Override
	public void setOrderClosed(long id) {
		orderService.setOrderClosed(id);
	}

	@Override
	public void setOrderCancelled(long id) {
		orderService.setOrderCancelled(id);
	}

	@Override
	public void addGarage(Garage garage) {
		garageService.create(garage);
	}

	@Override
	public void removeGarage(long id) {
		garageService.delete(id);
	}

	@Override
	public void addSit(Sit sit) {
		sitService.create(sit);
	}

	@Override
	public void removeSit(long id) {
		sitService.delete(id);
	}

	@Override
	public void showFreeSits() {
		System.out.println(sitService.showFreeSits());
	}

	@Override
	public void showFreeSitsAtDate(Date date) {
		System.out.println(sitService.showFreeSitsAtDate(date));
	}

	@Override
	public void showOrders(String parameter) {
		System.out.println(orderService.showExecutingOrders(parameter));
	}

	@Override
	public void showExecutingOrders(String parameter) {
		System.out.println(orderService.showExecutingOrders(parameter));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) {
		orderService.shiftOrderExecutionTime(days);
	}

	@Override
	public void showMasters(String parameter) {
		System.out.println(masterService.showMasters(parameter));

	}

	@Override
	public void showMastersExecutingByConcreteOrder(long id) {
		System.out.println(masterService.showOrderExecutingByConcreteMaster(id));
	}

	@Override
	public void showOrderExecutingByConcreteMaster(long id) {
		System.out.println(masterService.showOrderExecutingByConcreteMaster(id));
	}

	@Override
	public void showOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter) {
		System.out.println(orderService.showOrdersForPeriodOfTime(beforeDate, afterDate, parameter));
	}

	@Override
	public void showNearestFreeDate() {
		System.out.println(orderService.showNearestDate());
	}

}
