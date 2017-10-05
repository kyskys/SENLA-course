package controller;

import java.util.Date;

import entities.Garage;
import entities.Master;
import entities.Order;
import entities.Sit;
import service.*;
import service.intefraces.*;
import sort.SortParameters;
import util.Utils;

public class Controller implements IController {
	private IGarageService garageService = new GarageService();
	private IMasterService masterService = new MasterService();
	private IOrderService orderService = new OrderService();
	private ISitService sitService = new SitService();
	private Controller instance = getInstance();

	private Controller() {
	}

	private Controller getInstance() {
		if (instance == null) {
			return new Controller();
		} else {
			return instance;
		}
	}

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
	public void showMasters() {
		System.out.println(Utils.getListAsString(masterService.getAll()));
	}

	@Override
	public void showOrders() {
		System.out.println(Utils.getListAsString(orderService.getAll()));
	}

	@Override
	public void showGarages() {
		System.out.println(Utils.getListAsString(garageService.getAll()));
	}

	@Override
	public void showSits() {
		System.out.println(Utils.getListAsString(sitService.getAll()));
	}

	@Override
	public void showFreeSits() {
		System.out.println(Utils.getListAsString(sitService.getFreeSits()));
	}

	@Override
	public void showFreeSitsAtDate(Date date) {
		System.out.println(Utils.getListAsString(sitService.getFreeSitsAtDate(date)));
	}

	@Override
	public void showOrders(String parameter) {
		System.out
				.println(Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter))));
	}

	@Override
	public void showExecutingOrders(String parameter) {
		System.out
				.println(Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter))));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) {
		orderService.shiftOrderExecutionTime(days);
	}

	@Override
	public void showMasters(String parameter) {
		System.out.println(Utils.getListAsString(masterService.getAll(SortParameters.getValueOf(parameter))));

	}

	@Override
	public void showMastersExecutingConcreteOrder(long id) {
		System.out.println(Utils.getListAsString(orderService.getMastersExecutingConcreteOrder(id)));
	}

	@Override
	public void showOrderExecutingByConcreteMaster(long id) {
		System.out.println(masterService.getOrderExecutingByConcreteMaster(id));
	}

	@Override
	public void showOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter) {
		System.out.println(Utils.getListAsString(
				orderService.getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter))));
	}

	@Override
	public void showNearestFreeDate() {
		System.out.println(orderService.getNearestDate());
	}

}
