package com.senla.controller;

import java.util.Date;

import com.senla.entities.Garage;
import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.entities.Sit;

public interface IController {
	Garage getGarage(long id);

	Master getMaster(long id);

	Order getOrder(long id);

	Sit getSit(long id);

	void addMaster(Master master);

	void removeMaster(long id);

	void addOrder(Order order);

	void removeOrder(long id);

	void setOrderClosed(long id);

	void setOrderCancelled(long id);

	void addGarage(Garage garage);

	void removeGarage(long id);

	void addSit(Sit sit);

	void removeSit(long id);

	String getFreeSitsAsString();

	String getFreeSitsAtDateAsString(Date date);

	String getOrdersAsString(String parameter);

	String getExecutingOrdersAsString(String parameter);

	void shiftOrdersTimeExecution(int days);

	String getMastersAsString(String parameter);

	String getMastersExecutingConcreteOrderAsString(long id);

	String getOrderExecutingByConcreteMasterAsString(long id);

	String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter);

	String getNearestFreeDateAsString();

	String getMastersAsString();

	String getOrdersAsString();

	String getGaragesAsString();

	String getSitsAsString();

	void removeSitFromGarage(Long idSit, Long idGarage);

	void addOrderToMaster(Long idOrder, Long idMaster);

	void removeOrderFromMaster(Long idMaster);

	void addMasterToOrder(Long idMaster, Long idOrder);

	void removeMasterFromOrder(Long idMaster, Long idOrder);

	void addOrderToSit(Long idOrder, Long idSit);

	void removeOrderFromSit(Long idSit);

	String showFreeMastersOnDate(Date date);

	void addSitToGarage(Long idGarage, Long idSit);

}
