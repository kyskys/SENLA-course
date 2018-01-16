package com.senla.controller;

import java.sql.SQLException;
import java.sql.Date;

import com.senla.entities.Garage;
import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.service.interfaces.*;
import com.senla.sort.SortParameters;
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
	public void addMaster(Master master) throws SQLException {
		masterService.create(master);

	}

	@Override
	public void removeMaster(long id) throws SQLException {
		masterService.delete(id);

	}

	@Override
	public void addOrder(Order order) throws SQLException {
		orderService.create(order);

	}

	@Override
	public void removeOrder(long id) throws SQLException {
		orderService.delete(id);

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
	public void removeGarage(long id) throws SQLException {
		garageService.delete(id);

	}

	@Override
	public void addSit(Sit sit) throws SQLException {
		sitService.create(sit);

	}

	@Override
	public void removeSit(long id) throws SQLException {
		sitService.delete(id);

	}

	@Override
	public String getMastersAsString() throws SQLException {
		return Utils.getListAsString(masterService.getAll());
	}

	@Override
	public String getOrdersAsString() throws SQLException {
		return Utils.getListAsString(orderService.getAll());
	}

	@Override
	public String getGaragesAsString() throws SQLException {
		return Utils.getListAsString(garageService.getAll());
	}

	@Override
	public String getSitsAsString() throws SQLException {
		return Utils.getListAsString(sitService.getAll());
	}

	@Override
	public String getFreeSitsAsString() throws SQLException {
		return Utils.getListAsString(sitService.getFreeSits());
	}

	@Override
	public String getFreeSitsAtDateAsString(Date date) throws SQLException {
		return Utils.getListAsString(sitService.getFreeSitsAtDate(date));
	}

	@Override
	public String getOrdersAsString(String parameter) throws SQLException {
		return Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getExecutingOrdersAsString(String parameter) throws SQLException {
		return Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) throws SQLException {
		orderService.shiftOrderExecutionTime(days);

	}

	@Override
	public String getMastersAsString(String parameter) throws SQLException {
		return Utils.getListAsString(masterService.getAll(SortParameters.getValueOf(parameter)));

	}

	@Override
	public String getMastersExecutingConcreteOrderAsString(long id) throws SQLException {
		return Utils.getListAsString(orderService.getMastersExecutingConcreteOrder(id));
	}

	@Override
	public String getOrderExecutingByConcreteMasterAsString(long id) throws SQLException {
		return orderService.getOrderExecutingByConcreteMaster(id).toString();
	}

	@Override
	public String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter)
			throws SQLException {
		return Utils.getListAsString(
				orderService.getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getNearestFreeDateAsString() throws SQLException {
		return Utils.convertDateToString(orderService.getNearestDate());
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
	public void removeOrderFromMaster(Long idMaster, Long idOrder) throws SQLException {
		masterService.removeOrderFromMaster(idMaster, idOrder);

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
	public String showFreeMastersOnDate(Date date) throws SQLException {
		return Utils.getListAsString(masterService.getFreeMastersOnDate(date));
	}

}
