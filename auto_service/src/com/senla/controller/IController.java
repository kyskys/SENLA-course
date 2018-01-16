package com.senla.controller;

import java.sql.SQLException;
import java.sql.Date;

import com.senla.entities.Garage;
import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.entities.Sit;

public interface IController {
	Garage getGarage(long id) throws SQLException;

	Master getMaster(long id) throws SQLException;

	Order getOrder(long id) throws SQLException;

	Sit getSit(long id) throws SQLException;

	void addMaster(Master master) throws SQLException;

	void removeMaster(long id) throws SQLException;

	void addOrder(Order order) throws SQLException;

	void removeOrder(long id) throws SQLException;

	void setOrderClosed(long id, Boolean value) throws SQLException;

	void setOrderCancelled(long id, Boolean value) throws SQLException;

	void addGarage(Garage garage) throws SQLException;

	void removeGarage(long id) throws SQLException;

	void addSit(Sit sit) throws SQLException;

	void removeSit(long id) throws SQLException;

	String getFreeSitsAsString() throws SQLException;

	String getFreeSitsAtDateAsString(Date date) throws SQLException;

	String getOrdersAsString(String parameter) throws SQLException;

	String getExecutingOrdersAsString(String parameter) throws SQLException;

	void shiftOrdersTimeExecution(int days) throws SQLException;

	String getMastersAsString(String parameter) throws SQLException;

	String getMastersExecutingConcreteOrderAsString(long id) throws SQLException;

	String getOrderExecutingByConcreteMasterAsString(long id) throws SQLException;

	String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter) throws SQLException;

	String getNearestFreeDateAsString() throws SQLException;

	String getMastersAsString() throws SQLException;

	String getOrdersAsString() throws SQLException;

	String getGaragesAsString() throws SQLException;

	String getSitsAsString() throws SQLException;

	void removeSitFromGarage(Long idSit, Long idGarage) throws SQLException;

	void addOrderToMaster(Long idOrder, Long idMaster) throws SQLException;

	void removeOrderFromMaster(Long idMaster, Long idOrder) throws SQLException;

	void addMasterToOrder(Long idMaster, Long idOrder) throws SQLException;

	void removeMasterFromOrder(Long idMaster, Long idOrder) throws SQLException;

	void addOrderToSit(Long idOrder, Long idSit) throws SQLException;

	void removeOrderFromSit(Long idSit) throws SQLException;

	String showFreeMastersOnDate(Date date) throws SQLException;

	void addSitToGarage(Long idGarage, Long idSit) throws SQLException;

}
