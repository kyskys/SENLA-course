package com.senla.controller;

import java.sql.Date;
import java.util.List;

import com.senla.entities.*;
import com.senla.service.interfaces.*;
import com.senla.util.SortParameters;

import annotation.Configurable;
import annotation.Injectable;
import util.AnnotationHandler;

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

	public Controller() {
		AnnotationHandler.configure(this);
	}

	@Override
	public void addMaster(Master master) {
		masterService.create(master);

	}

	@Override
	public void removeMaster(Master master) {
		masterService.delete(master);

	}

	@Override
	public void addOrder(Order order) {
		orderService.create(order);

	}

	@Override
	public void removeOrder(Order order) {
		orderService.delete(order);

	}

	@Override
	public void setOrderClosed(long id, Boolean value) {
		orderService.setOrderClosed(id, value);

	}

	@Override
	public void setOrderCancelled(long id, Boolean value) {
		orderService.setOrderCancelled(id, value);

	}

	@Override
	public void addGarage(Garage garage) {
		garageService.create(garage);

	}

	@Override
	public void removeGarage(Garage garage) {
		garageService.delete(garage);

	}

	@Override
	public void addSit(Sit sit) {
		sitService.create(sit);

	}

	@Override
	public void removeSit(Sit sit) {
		sitService.delete(sit);

	}

	@Override
	public List<Master> getMasters() {
		return masterService.getAll();
	}

	@Override
	public List<Order> getOrders() {
		return orderService.getAll();
	}

	@Override
	public List<Garage> getGarages() {
		return garageService.getAll();
	}

	@Override
	public List<Sit> getSits() {
		return sitService.getAll();
	}

	@Override
	public List<Sit> getFreeSits() {
		return sitService.getFreeSits();
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) {
		return sitService.getFreeSitsAtDate(date);
	}

	@Override
	public List<Order> getOrders(String parameter) {
		return orderService.getExecutingOrders(SortParameters.getValueOf(parameter));
	}

	@Override
	public List<Order> getExecutingOrders(String parameter) {
		return orderService.getExecutingOrders(SortParameters.getValueOf(parameter));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) {
		orderService.shiftOrderExecutionTime(days);

	}

	@Override
	public List<Master> getMasters(String parameter) {
		return masterService.getAll(SortParameters.getValueOf(parameter));

	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(long id) {
		return orderService.getMastersExecutingConcreteOrder(id);
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(long id) {
		return masterService.getOrderExecutingByConcreteMaster(id);
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter) {
		return orderService.getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter));
	}

	@Override
	public Date getNearestFreeDate() {
		return orderService.getNearestDate();
	}

	@Override
	public Garage getGarage(long id) {
		return garageService.get(id);
	}

	@Override
	public Master getMaster(long id) {
		return masterService.get(id);
	}

	@Override
	public Order getOrder(long id) {
		return orderService.get(id);
	}

	@Override
	public Sit getSit(long id) {
		return sitService.get(id);
	}

	@Override
	public void addSitToGarage(Long idGarage, Long idSit) {
		garageService.addSitToGarage(idGarage, idSit);

	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) {
		garageService.removeSitFromGarage(idSit, idGarage);

	}

	@Override
	public void addOrderToMaster(Long idOrder, Long idMaster) {
		masterService.addOrderToMaster(idOrder, idMaster);

	}

	@Override
	public void removeOrderFromMaster(Long idMaster) {
		masterService.removeOrderFromMaster(idMaster);

	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) {
		orderService.addMasterToOrder(idMaster, idOrder);

	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) {
		orderService.removeMasterFromOrder(idMaster, idOrder);

	}

	@Override
	public void addOrderToSit(Long idOrder, Long idSit) {
		sitService.addOrderToSit(idOrder, idSit);

	}

	@Override
	public void removeOrderFromSit(Long idSit) {
		sitService.removeOrderFromSit(idSit);

	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) {
		return masterService.getFreeMastersOnDate(date);
	}

	@Override
	public void updateMaster(Master master) {
		masterService.update(master);
	}

	@Override
	public void updateGarage(Garage garage) {
		garageService.update(garage);
	}

	@Override
	public void updateOrder(Order order) {
		orderService.update(order);
	}

	@Override
	public void updateSit(Sit sit) {
		sitService.update(sit);
	}

	@Override
	public void deleteMaster(Master master) {
		masterService.delete(master);
	}

	@Override
	public void deleteGarage(Garage garage) {
		garageService.delete(garage);
	}

	@Override
	public void deleteOrder(Order order) {
		orderService.delete(order);
	}

	@Override
	public void deleteSit(Sit sit) {
		sitService.delete(sit);
	}

}
