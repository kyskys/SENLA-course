package com.senla.controller;

import java.sql.Date;

import com.senla.entities.*;
import com.senla.service.interfaces.*;
import com.senla.util.SortParameters;
import com.senla.util.Utils;

import annotation.Configurable;
import annotation.Injectable;

public class Controller implements IController {
	@Injectable
	@Configurable
	private IOrderService orderService;
	@Injectable
	@Configurable
	private IMasterService masterService;
	@Injectable
	@Configurable
	private ISitService sitService;
	@Injectable
	@Configurable
	private IGarageService garageService;

	@Override
	public void addMaster(Master master) throws Throwable {
		masterService.create(master);

	}

	@Override
	public void removeMaster(Master master) throws Throwable {
		masterService.delete(master);

	}

	@Override
	public void addOrder(Order order) throws Throwable {
		orderService.create(order);

	}

	@Override
	public void removeOrder(Order order) throws Throwable {
		orderService.delete(order);

	}

	@Override
	public void setOrderClosed(long id, Boolean value) throws Throwable {
		orderService.setOrderClosed(id, value);

	}

	@Override
	public void setOrderCancelled(long id, Boolean value) throws Throwable {
		orderService.setOrderCancelled(id, value);

	}

	@Override
	public void addGarage(Garage garage) throws Throwable {
		garageService.create(garage);

	}

	@Override
	public void removeGarage(Garage garage) throws Throwable {
		garageService.delete(garage);

	}

	@Override
	public void addSit(Sit sit) throws Throwable {
		sitService.create(sit);

	}

	@Override
	public void removeSit(Sit sit) throws Throwable {
		sitService.delete(sit);

	}

	@Override
	public String getMastersAsString() throws Throwable {
		return Utils.getListAsString(masterService.getAll());
	}

	@Override
	public String getOrdersAsString() throws Throwable {
		return Utils.getListAsString(orderService.getAll());
	}

	@Override
	public String getGaragesAsString() throws Throwable {
		return Utils.getListAsString(garageService.getAll());
	}

	@Override
	public String getSitsAsString() throws Throwable {
		return Utils.getListAsString(sitService.getAll());
	}

	@Override
	public String getFreeSitsAsString() throws Throwable {
		return Utils.getListAsString(sitService.getFreeSits());
	}

	@Override
	public String getFreeSitsAtDateAsString(Date date) throws Throwable {
		return Utils.getListAsString(sitService.getFreeSitsAtDate(date));
	}

	@Override
	public String getOrdersAsString(String parameter) throws Throwable {
		return Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getExecutingOrdersAsString(String parameter) throws Throwable {
		return Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) throws Throwable {
		orderService.shiftOrderExecutionTime(days);

	}

	@Override
	public String getMastersAsString(String parameter) throws Throwable {
		return Utils.getListAsString(masterService.getAll(SortParameters.getValueOf(parameter)));

	}

	@Override
	public String getMastersExecutingConcreteOrderAsString(long id) throws Throwable {
		return Utils.getListAsString(orderService.getMastersExecutingConcreteOrder(id));
	}

	@Override
	public String getOrderExecutingByConcreteMasterAsString(long id) throws Throwable {
		return masterService.getOrderExecutingByConcreteMaster(id).toString();
	}

	@Override
	public String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter) throws Throwable {
		return Utils.getListAsString(
				orderService.getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getNearestFreeDateAsString() throws Throwable {
		return Utils.convertDateToString(orderService.getNearestDate());
	}

	@Override
	public Garage getGarage(long id) throws Throwable {
		return garageService.get(id);
	}

	@Override
	public Master getMaster(long id) throws Throwable {
		return masterService.get(id);
	}

	@Override
	public Order getOrder(long id) throws Throwable {
		return orderService.get(id);
	}

	@Override
	public Sit getSit(long id) throws Throwable {
		return sitService.get(id);
	}

	@Override
	public void addSitToGarage(Long idGarage, Long idSit) throws Throwable {
		garageService.addSitToGarage(idGarage, idSit);

	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) throws Throwable {
		garageService.removeSitFromGarage(idSit, idGarage);

	}

	@Override
	public void addOrderToMaster(Long idOrder, Long idMaster) throws Throwable {
		masterService.addOrderToMaster(idOrder, idMaster);

	}

	@Override
	public void removeOrderFromMaster(Long idMaster) throws Throwable {
		masterService.removeOrderFromMaster(idMaster);

	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) throws Throwable {
		orderService.addMasterToOrder(idMaster, idOrder);

	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) throws Throwable {
		orderService.removeMasterFromOrder(idMaster, idOrder);

	}

	@Override
	public void addOrderToSit(Long idOrder, Long idSit) throws Throwable {
		sitService.addOrderToSit(idOrder, idSit);

	}

	@Override
	public void removeOrderFromSit(Long idSit) throws Throwable {
		sitService.removeOrderFromSit(idSit);

	}

	@Override
	public String showFreeMastersOnDate(Date date) throws Throwable {
		return Utils.getListAsString(masterService.getFreeMastersOnDate(date));
	}

}
