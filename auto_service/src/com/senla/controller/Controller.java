package com.senla.controller;

import java.util.Date;

import com.senla.entities.Garage;
import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.manager.interfaces.IServiceManager;
import com.senla.sort.SortParameters;
import com.senla.util.Utils;

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
	public String getMastersAsString() {
		return Utils.getListAsString(serviceManager.getMasterService().getAll());
	}

	@Override
	public String getOrdersAsString() {
		return Utils.getListAsString(serviceManager.getOrderService().getAll());
	}

	@Override
	public String getGaragesAsString() {
		return Utils.getListAsString(serviceManager.getGarageService().getAll());
	}

	@Override
	public String getSitsAsString() {
		return Utils.getListAsString(serviceManager.getSitService().getAll());
	}

	@Override
	public String getFreeSitsAsString() {
		return Utils.getListAsString(serviceManager.getSitService().getFreeSits());
	}

	@Override
	public String getFreeSitsAtDateAsString(Date date) {
		return Utils.getListAsString(serviceManager.getSitService().getFreeSitsAtDate(date));
	}

	@Override
	public String getOrdersAsString(String parameter) {
		return Utils.getListAsString(
				serviceManager.getOrderService().getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getExecutingOrdersAsString(String parameter) {
		return Utils.getListAsString(
				serviceManager.getOrderService().getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) {
		serviceManager.getOrderService().shiftOrderExecutionTime(days);
	}

	@Override
	public String getMastersAsString(String parameter) {
		return Utils.getListAsString(serviceManager.getMasterService().getAll(SortParameters.getValueOf(parameter)));

	}

	@Override
	public String getMastersExecutingConcreteOrderAsString(long id) {
		return Utils.getListAsString(serviceManager.getOrderService().getMastersExecutingConcreteOrder(id));
	}

	@Override
	public String getOrderExecutingByConcreteMasterAsString(long id) {
		return serviceManager.getMasterService().getOrderExecutingByConcreteMaster(id).toString();
	}

	@Override
	public String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter) {
		return Utils.getListAsString(serviceManager.getOrderService().getOrdersForPeriodOfTime(beforeDate, afterDate,
				SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getNearestFreeDateAsString() {
		return Utils.convertDateToString(serviceManager.getOrderService().getNearestDate());
	}

	@Override
	public Garage getGarage(long id) {
		return serviceManager.getGarageService().get(id);
	}

	@Override
	public Master getMaster(long id) {
		return serviceManager.getMasterService().get(id);
	}

	@Override
	public Order getOrder(long id) {
		return serviceManager.getOrderService().get(id);
	}

	@Override
	public Sit getSit(long id) {
		return serviceManager.getSitService().get(id);
	}

	@Override
	public void addSitToGarage(Long idGarage) {
		serviceManager.getGarageService().addSitToGarage(idGarage);
	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) {
		serviceManager.getGarageService().removeSitFromGarage(idSit, idGarage);
	}

	@Override
	public void addOrderToMaster(Long idOrder, Long idMaster) {
		serviceManager.getMasterService().addOrderToMaster(idOrder, idMaster);
	}

	@Override
	public void removeOrderFromMaster(Long idMaster) {
		serviceManager.getMasterService().removeOrderFromMaster(idMaster);
	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) {
		serviceManager.getOrderService().addMasterToOrder(idMaster, idOrder);
	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) {
		serviceManager.getOrderService().removeMasterFromOrder(idMaster, idOrder);
	}

	@Override
	public void addOrderToSit(Long idOrder, Long idSit) {
		serviceManager.getSitService().addOrderToSit(idOrder, idSit);
	}

	@Override
	public void removeOrderFromSit(Long idSit) {
		serviceManager.getSitService().removeOrderFromSit(idSit);
	}

	@Override
	public String showFreeMastersOnDate(Date date) {
		return Utils.getListAsString(serviceManager.getMasterService().getFreeMastersOnDate(date));
	}

}
