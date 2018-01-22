package com.senla.controller;

import com.senla.entities.*;

import java.sql.Date;
import java.util.List;

public interface IController {
	void updateMaster(Master master);

	void updateGarage(Garage garage);

	void updateOrder(Order order);

	void updateSit(Sit sit);

	void deleteMaster(Master master);

	void deleteGarage(Garage garage);

	void deleteOrder(Order order);

	void deleteSit(Sit sit);

	Garage getGarage(long id);

	Master getMaster(long id);

	Order getOrder(long id);

	Sit getSit(long id);

	void addMaster(Master master);

	void removeMaster(Master master);

	void addOrder(Order order);

	void removeOrder(Order order);

	void setOrderClosed(long id, Boolean value);

	void setOrderCancelled(long id, Boolean value);

	void addGarage(Garage garage);

	void removeGarage(Garage garage);

	void addSit(Sit sit);

	void removeSit(Sit sit);

	List<Sit> getFreeSits();

	List<Sit> getFreeSitsAtDate(Date date);

	List<Order> getOrders(String parameter);

	List<Order> getExecutingOrders(String parameter);

	void shiftOrdersTimeExecution(int days);

	List<Master> getMasters(String parameter);

	List<Master> getMastersExecutingConcreteOrder(long id);

	Order getOrderExecutingByConcreteMaster(long id);

	List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter);

	Date getNearestFreeDate();

	List<Master> getMasters();

	List<Order> getOrders();

	List<Garage> getGarages();

	List<Sit> getSits();

	void removeSitFromGarage(Long idSit, Long idGarage);

	void addOrderToMaster(Long idOrder, Long idMaster);

	void removeOrderFromMaster(Long idMaster);

	void addMasterToOrder(Long idMaster, Long idOrder);

	void removeMasterFromOrder(Long idMaster, Long idOrder);

	void addOrderToSit(Long idOrder, Long idSit);

	void removeOrderFromSit(Long idSit);

	List<Master> getFreeMastersOnDate(Date date);

	void addSitToGarage(Long idGarage, Long idSit);

}
