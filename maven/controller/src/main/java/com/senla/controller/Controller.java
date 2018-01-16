package com.senla.controller;

import java.sql.Date;
import java.sql.SQLException;
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
	public void addMaster(Master master) throws SQLException {
		masterService.create(master);

	}

	@Override
	public void removeMaster(Master master) throws SQLException {
		masterService.delete(master);

	}

	@Override
	public void addOrder(Order order) throws SQLException {
		orderService.create(order);

	}

	@Override
	public void removeOrder(Order order) throws SQLException {
		orderService.delete(order);

	}

	@Override
	public void setOrderClosed(long id, Boolean value) throws SQLException {
		orderService.setOrderClosed(id, value);

	}

	@Override
	public void setOrderCancelled(long id, Boolean value) throws SQLException {
		orderService.setOrderCancelled(id, value);

	}

	@Override
	public void addGarage(Garage garage) throws SQLException {
		garageService.create(garage);

	}

	@Override
	public void removeGarage(Garage garage) throws SQLException {
		garageService.delete(garage);

	}

	@Override
	public void addSit(Sit sit) throws SQLException {
		sitService.create(sit);

	}

	@Override
	public void removeSit(Sit sit) throws SQLException {
		sitService.delete(sit);

	}

	@Override
	public List<Master> getMasters() throws SQLException {
		return masterService.getAll();
	}

	@Override
	public List<Order> getOrders() throws SQLException {
		return orderService.getAll();
	}

	@Override
	public List<Garage> getGarages() throws SQLException {
		return garageService.getAll();
	}

	@Override
	public List<Sit> getSits() throws SQLException {
		return sitService.getAll();
	}

	@Override
	public List<Sit> getFreeSits() throws SQLException {
		return sitService.getFreeSits();
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) throws SQLException {
		return sitService.getFreeSitsAtDate(date);
	}

	@Override
	public List<Order> getOrders(String parameter) throws SQLException {
		return orderService.getExecutingOrders(SortParameters.getValueOf(parameter));
	}

	@Override
	public List<Order> getExecutingOrders(String parameter) throws SQLException {
		return orderService.getExecutingOrders(SortParameters.getValueOf(parameter));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) throws SQLException {
		orderService.shiftOrderExecutionTime(days);

	}

	@Override
	public List<Master> getMasters(String parameter) throws SQLException {
		return masterService.getAll(SortParameters.getValueOf(parameter));

	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(long id) throws SQLException {
		return orderService.getMastersExecutingConcreteOrder(id);
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(long id) throws SQLException {
		return masterService.getOrderExecutingByConcreteMaster(id);
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter) throws SQLException {
		return 
				orderService.getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter));
	}

	@Override
	public Date getNearestFreeDate() throws SQLException {
		return orderService.getNearestDate();
	}

	@Override
	public Garage getGarage(long id) throws SQLException {
		return garageService.get(id);
	}

	@Override
	public Master getMaster(long id) throws SQLException {
		return masterService.get(id);
	}

	@Override
	public Order getOrder(long id) throws SQLException {
		return orderService.get(id);
	}

	@Override
	public Sit getSit(long id) throws SQLException {
		return sitService.get(id);
	}

	@Override
	public void addSitToGarage(Long idGarage, Long idSit) throws SQLException {
		garageService.addSitToGarage(idGarage, idSit);

	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) throws SQLException {
		garageService.removeSitFromGarage(idSit, idGarage);

	}

	@Override
	public void addOrderToMaster(Long idOrder, Long idMaster) throws SQLException {
		masterService.addOrderToMaster(idOrder, idMaster);

	}

	@Override
	public void removeOrderFromMaster(Long idMaster) throws SQLException {
		masterService.removeOrderFromMaster(idMaster);

	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) throws SQLException {
		orderService.addMasterToOrder(idMaster, idOrder);

	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) throws SQLException {
		orderService.removeMasterFromOrder(idMaster, idOrder);

	}

	@Override
	public void addOrderToSit(Long idOrder, Long idSit) throws SQLException {
		sitService.addOrderToSit(idOrder, idSit);

	}

	@Override
	public void removeOrderFromSit(Long idSit) throws SQLException {
		sitService.removeOrderFromSit(idSit);

	}

	@Override
	public List<Master> showFreeMastersOnDate(Date date) throws SQLException {
		return masterService.getFreeMastersOnDate(date);
	}

}
