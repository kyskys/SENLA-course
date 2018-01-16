package com.senla.controller;

import com.senla.entities.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


public interface IController {
	Garage getGarage(long id) throws SQLException;

	Master getMaster(long id) throws SQLException;

	Order getOrder(long id) throws SQLException;

	Sit getSit(long id) throws SQLException;

	void addMaster(Master master) throws SQLException;

	void removeMaster(Master master) throws SQLException;

	void addOrder(Order order) throws SQLException;

	void removeOrder(Order order) throws SQLException;

	void setOrderClosed(long id, Boolean value) throws SQLException;

	void setOrderCancelled(long id, Boolean value) throws SQLException;

	void addGarage(Garage garage) throws SQLException;

	void removeGarage(Garage garage) throws SQLException;

	void addSit(Sit sit) throws SQLException;

	void removeSit(Sit sit) throws SQLException;

	List<Sit> getFreeSits() throws SQLException;

	List<Sit> getFreeSitsAtDate(Date date) throws SQLException;

	List<Order> getOrders(String parameter) throws SQLException;

	List<Order> getExecutingOrders(String parameter) throws SQLException;

	void shiftOrdersTimeExecution(int days) throws SQLException;

	List<Master> getMasters(String parameter) throws SQLException;

	List<Master> getMastersExecutingConcreteOrder(long id) throws SQLException;

	Order getOrderExecutingByConcreteMaster(long id) throws SQLException;

	List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter) throws SQLException;

	Date getNearestFreeDate() throws SQLException;

	List<Master> getMasters() throws SQLException;

	List<Order> getOrders() throws SQLException;

	List<Garage> getGarages() throws SQLException;

	List<Sit> getSits() throws SQLException;

	void removeSitFromGarage(Long idSit, Long idGarage) throws SQLException;

	void addOrderToMaster(Long idOrder, Long idMaster) throws SQLException;

	void removeOrderFromMaster(Long idMaster) throws SQLException;

	void addMasterToOrder(Long idMaster, Long idOrder) throws SQLException;

	void removeMasterFromOrder(Long idMaster, Long idOrder) throws SQLException;

	void addOrderToSit(Long idOrder, Long idSit) throws SQLException;

	void removeOrderFromSit(Long idSit) throws SQLException;

	List<Master> showFreeMastersOnDate(Date date) throws SQLException;

	void addSitToGarage(Long idGarage, Long idSit) throws SQLException;

}
