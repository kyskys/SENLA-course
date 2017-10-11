package controller;

import java.util.Date;

import entities.Garage;
import entities.Master;
import entities.Order;
import entities.Sit;
import manager.interfaces.IServiceManager;
import manager.interfaces.IStorageManager;
import service.*;
import service.intefraces.*;
import sort.SortParameters;
import util.Utils;

public class Controller implements IController {
	private IServiceManager serviceManager;

	public Controller(IServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	@Override
	public void addMaster(Master master) {
		serviceManager.getMasterService().create(master);
	}

	@Override
	public void removeMaster(long id) {
		serviceManager.getMasterService().delete(id);
	}

	@Override
	public void addOrder(Order order) {
		serviceManager.getOrderService().create(order);
	}

	@Override
	public void removeOrder(long id) {
		serviceManager.getOrderService().delete(id);
	}

	@Override
	public void setOrderClosed(long id) {
		serviceManager.getOrderService().setOrderClosed(id);
	}

	@Override
	public void setOrderCancelled(long id) {
		serviceManager.getOrderService().setOrderCancelled(id);
	}

	@Override
	public void addGarage(Garage garage) {
		serviceManager.getGarageService().create(garage);
	}

	@Override
	public void removeGarage(long id) {
		serviceManager.getGarageService().delete(id);
	}

	@Override
	public void addSit(Sit sit) {
		serviceManager.getSitService().create(sit);
	}

	@Override
	public void removeSit(long id) {
		serviceManager.getSitService().delete(id);
	}

	@Override
	public void showMasters() {
		System.out.println(Utils.getListAsString(serviceManager.getMasterService().getAll()));
	}

	@Override
	public void showOrders() {
		System.out.println(Utils.getListAsString(serviceManager.getOrderService().getAll()));
	}

	@Override
	public void showGarages() {
		System.out.println(Utils.getListAsString(serviceManager.getGarageService().getAll()));
	}

	@Override
	public void showSits() {
		System.out.println(Utils.getListAsString(serviceManager.getSitService().getAll()));
	}

	@Override
	public void showFreeSits() {
		System.out.println(Utils.getListAsString(serviceManager.getSitService().getFreeSits()));
	}

	@Override
	public void showFreeSitsAtDate(Date date) {
		System.out.println(Utils.getListAsString(serviceManager.getSitService().getFreeSitsAtDate(date)));
	}

	@Override
	public void showOrders(String parameter) {
		System.out
				.println(Utils.getListAsString(serviceManager.getOrderService().getExecutingOrders(SortParameters.getValueOf(parameter))));
	}

	@Override
	public void showExecutingOrders(String parameter) {
		System.out
				.println(Utils.getListAsString(serviceManager.getOrderService().getExecutingOrders(SortParameters.getValueOf(parameter))));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) {
		serviceManager.getOrderService().shiftOrderExecutionTime(days);
	}

	@Override
	public void showMasters(String parameter) {
		System.out.println(Utils.getListAsString(serviceManager.getMasterService().getAll(SortParameters.getValueOf(parameter))));

	}

	@Override
	public void showMastersExecutingConcreteOrder(long id) {
		System.out.println(Utils.getListAsString(serviceManager.getOrderService().getMastersExecutingConcreteOrder(id)));
	}

	@Override
	public void showOrderExecutingByConcreteMaster(long id) {
		System.out.println(serviceManager.getMasterService().getOrderExecutingByConcreteMaster(id));
	}

	@Override
	public void showOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter) {
		System.out.println(Utils.getListAsString(
				serviceManager.getOrderService().getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter))));
	}

	@Override
	public void showNearestFreeDate() {
		System.out.println(serviceManager.getOrderService().getNearestDate());
	}

}
