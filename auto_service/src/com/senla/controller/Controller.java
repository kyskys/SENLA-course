package com.senla.controller;

import java.util.Date;

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
	public void addMaster(Master master) {
		synchronized (masterService) {
			masterService.create(master);
		}
	}

	@Override
	public void removeMaster(long id) {
		synchronized (masterService) {
			masterService.delete(id);
		}
	}

	@Override
	public void addOrder(Order order) {
		synchronized (orderService) {
			orderService.create(order);
		}
	}

	@Override
	public void removeOrder(long id) {
		synchronized (orderService) {
			orderService.delete(id);
		}
	}

	@Override
	public void setOrderClosed(long id) {
		synchronized (orderService) {
			orderService.setOrderClosed(id);
		}
	}

	@Override
	public void setOrderCancelled(long id) {
		synchronized (orderService) {
			orderService.setOrderCancelled(id);
		}

	}

	@Override
	public void addGarage(Garage garage) {
		synchronized (garageService) {
			garageService.create(garage);
		}
	}

	@Override
	public void removeGarage(long id) {
		synchronized (garageService) {
			garageService.delete(id);
		}
	}

	@Override
	public void addSit(Sit sit) {
		synchronized (sitService) {
			sitService.create(sit);
		}
	}

	@Override
	public void removeSit(long id) {
		synchronized (sitService) {
			sitService.delete(id);
		}
	}

	@Override
	public String getMastersAsString() {
		return Utils.getListAsString(masterService.getAll());
	}

	@Override
	public String getOrdersAsString() {
		return Utils.getListAsString(orderService.getAll());
	}

	@Override
	public String getGaragesAsString() {
		return Utils.getListAsString(garageService.getAll());
	}

	@Override
	public String getSitsAsString() {
		return Utils.getListAsString(sitService.getAll());
	}

	@Override
	public String getFreeSitsAsString() {
		return Utils.getListAsString(sitService.getFreeSits());
	}

	@Override
	public String getFreeSitsAtDateAsString(Date date) {
		return Utils.getListAsString(sitService.getFreeSitsAtDate(date));
	}

	@Override
	public String getOrdersAsString(String parameter) {
		return Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getExecutingOrdersAsString(String parameter) {
		return Utils.getListAsString(orderService.getExecutingOrders(SortParameters.getValueOf(parameter)));
	}

	@Override
	public void shiftOrdersTimeExecution(int days) {
		synchronized (orderService) {
			orderService.shiftOrderExecutionTime(days);
		}
	}

	@Override
	public String getMastersAsString(String parameter) {
		return Utils.getListAsString(masterService.getAll(SortParameters.getValueOf(parameter)));

	}

	@Override
	public String getMastersExecutingConcreteOrderAsString(long id) {
		return Utils.getListAsString(orderService.getMastersExecutingConcreteOrder(id));
	}

	@Override
	public String getOrderExecutingByConcreteMasterAsString(long id) {
		return masterService.getOrderExecutingByConcreteMaster(id).toString();
	}

	@Override
	public String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter) {
		return Utils.getListAsString(
				orderService.getOrdersForPeriodOfTime(beforeDate, afterDate, SortParameters.getValueOf(parameter)));
	}

	@Override
	public String getNearestFreeDateAsString() {
		return Utils.convertDateToString(orderService.getNearestDate());
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
		synchronized (garageService) {
			garageService.addSitToGarage(idGarage, idSit);
		}
	}

	@Override
	public void removeSitFromGarage(Long idSit, Long idGarage) {
		synchronized (garageService) {
			garageService.removeSitFromGarage(idSit, idGarage);
		}
	}

	@Override
	public void addOrderToMaster(Long idOrder, Long idMaster) {
		synchronized (masterService) {
			masterService.addOrderToMaster(idOrder, idMaster);
		}
	}

	@Override
	public void removeOrderFromMaster(Long idMaster) {
		synchronized (masterService) {
			masterService.removeOrderFromMaster(idMaster);
		}
	}

	@Override
	public void addMasterToOrder(Long idMaster, Long idOrder) {
		synchronized (orderService) {
			orderService.addMasterToOrder(idMaster, idOrder);
		}
	}

	@Override
	public void removeMasterFromOrder(Long idMaster, Long idOrder) {
		synchronized (orderService) {
			orderService.removeMasterFromOrder(idMaster, idOrder);
		}
	}

	@Override
	public void addOrderToSit(Long idOrder, Long idSit) {
		synchronized (sitService) {
			sitService.addOrderToSit(idOrder, idSit);
		}
	}

	@Override
	public void removeOrderFromSit(Long idSit) {
		synchronized (sitService) {
			sitService.removeOrderFromSit(idSit);
		}
	}

	@Override
	public String showFreeMastersOnDate(Date date) {
		return Utils.getListAsString(masterService.getFreeMastersOnDate(date));
	}

}
