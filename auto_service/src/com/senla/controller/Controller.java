package com.senla.controller;

import java.util.Date;

import com.senla.entities.*;
import com.senla.service.intefraces.*;
import com.senla.sort.SortParameters;
import com.senla.util.Utils;

import dependency.DependencyManager;

public class Controller implements IController {

	@Override
	public void addMaster(Master master) {
		DependencyManager.getInstance(IMasterService.class).create(master);
	}

	@Override
	public void removeMaster(long id) {
		DependencyManager.getInstance(IMasterService.class).delete(id);
	}

	@Override
	public void addOrder(Order order) {
		DependencyManager.getInstance(IOrderService.class).create(order);
	}

	@Override
	public void removeOrder(long id) {
		DependencyManager.getInstance(IOrderService.class).delete(id);
	}

	@Override
	public void setOrderClosed(long id) {
		DependencyManager.getInstance(IOrderService.class).setOrderClosed(id);
	}

	@Override
	public void setOrderCancelled(long id) {
		DependencyManager.getInstance(IOrderService.class).setOrderCancelled(id);
	}

	@Override
	public void addGarage(Garage garage) {
		DependencyManager.getInstance(IGarageService.class).create(garage);
	}

	@Override
	public void removeGarage(long id) {
		DependencyManager.getInstance(IGarageService.class).delete(id);
	}

	@Override
	public void addSit(Sit sit) {
		DependencyManager.getInstance(ISitService.class).create(sit);
	}

	@Override
	public void removeSit(long id) {
		DependencyManager.getInstance(ISitService.class).delete(id);
	}

	@Override
	public String getMastersAsString() {
		return Utils.getListAsString(DependencyManager.getInstance(IMasterService.class).getAll());
	}

	@Override
	public String getOrdersAsString() {
		return Utils.getListAsString(DependencyManager.getInstance(IOrderService.class).getAll());
	}

	@Override
	public String getGaragesAsString() {
		return Utils.getListAsString(DependencyManager.getInstance(IGarageService.class).getAll());
	}

	@Override
	public String getSitsAsString() {
		return Utils.getListAsString(DependencyManager.getInstance(ISitService.class).getAll());
	}

	@Override
	public String getFreeSitsAsString() {
		return Utils.getListAsString(DependencyManager.getInstance(ISitService.class).getFreeSits());
	}

	@Override
	public String getFreeSitsAtDateAsString(Date date) {
		return Utils.getListAsString(DependencyManager.getInstance(ISitService.class).getFreeSitsAtDate(date));
	}

	@Override
	public String getOrdersAsString(String parameter) {
		return Utils.getListAsString(
				DependencyManager.getInstance(IOrderService.class).getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getExecutingOrdersAsString(String parameter) {
		return Utils.getListAsString(
				DependencyManager.getInstance(IOrderService.class).getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) {
		DependencyManager.getInstance(IOrderService.class).shiftOrderExecutionTime(days);
	}

	@Override
	public String getMastersAsString(String parameter) {
		return Utils.getListAsString(DependencyManager.getInstance(IMasterService.class).getAll(SortParameters.getValueOf(parameter)));

	}

	@Override
	public String getMastersExecutingConcreteOrderAsString(long id) {
		return Utils.getListAsString(DependencyManager.getInstance(IOrderService.class).getMastersExecutingConcreteOrder(id));
	}

	@Override
	public String getOrderExecutingByConcreteMasterAsString(long id) {
		return DependencyManager.getInstance(IMasterService.class).getOrderExecutingByConcreteMaster(id).toString();
	}

	@Override
	public String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter) {
		return Utils.getListAsString(DependencyManager.getInstance(IOrderService.class).getOrdersForPeriodOfTime(beforeDate, afterDate,
				SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getNearestFreeDateAsString() {
		return Utils.convertDateToString(DependencyManager.getInstance(IOrderService.class).getNearestDate());
	}

	@Override
	public Garage getGarage(long id) {
		return DependencyManager.getInstance(IGarageService.class).get(id);
	}

	@Override
	public Master getMaster(long id) {
		return DependencyManager.getInstance(IMasterService.class).get(id);
	}

	@Override
	public Order getOrder(long id) {
		return DependencyManager.getInstance(IOrderService.class).get(id);
	}

	@Override
	public Sit getSit(long id) {
		return DependencyManager.getInstance(ISitService.class).get(id);
	}

	@Override
	public void addSitToGarage(Long idGarage) {
		DependencyManager.getInstance(IGarageService.class).addSitToGarage(idGarage);
	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) {
		DependencyManager.getInstance(IGarageService.class).removeSitFromGarage(idSit, idGarage);
	}

	@Override
	public void addOrderToMaster(Long idOrder, Long idMaster) {
		DependencyManager.getInstance(IMasterService.class).addOrderToMaster(idOrder, idMaster);
	}

	@Override
	public void removeOrderFromMaster(Long idMaster) {
		DependencyManager.getInstance(IMasterService.class).removeOrderFromMaster(idMaster);
	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) {
		DependencyManager.getInstance(IOrderService.class).addMasterToOrder(idMaster, idOrder);
	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) {
		DependencyManager.getInstance(IOrderService.class).removeMasterFromOrder(idMaster, idOrder);
	}

	@Override
	public void addOrderToSit(Long idOrder, Long idSit) {
		DependencyManager.getInstance(ISitService.class).addOrderToSit(idOrder, idSit);
	}

	@Override
	public void removeOrderFromSit(Long idSit) {
		DependencyManager.getInstance(ISitService.class).removeOrderFromSit(idSit);
	}

	@Override
	public String showFreeMastersOnDate(Date date) {
		return Utils.getListAsString(DependencyManager.getInstance(IMasterService.class).getFreeMastersOnDate(date));
	}

}
