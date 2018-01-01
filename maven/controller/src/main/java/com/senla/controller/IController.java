package com.senla.controller;

import com.senla.entities.*;

import java.sql.Date;


public interface IController {
	Garage getGarage(long id) throws Throwable;

	Master getMaster(long id) throws Throwable;

	Order getOrder(long id) throws Throwable;

	Sit getSit(long id) throws Throwable;

	void addMaster(Master master) throws Throwable;

	void removeMaster(Master master) throws Throwable;

	void addOrder(Order order) throws Throwable;

	void removeOrder(Order order) throws Throwable;

	void setOrderClosed(long id, Boolean value) throws Throwable;

	void setOrderCancelled(long id, Boolean value) throws Throwable;

	void addGarage(Garage garage) throws Throwable;

	void removeGarage(Garage garage) throws Throwable;

	void addSit(Sit sit) throws Throwable;

	void removeSit(Sit sit) throws Throwable;

	String getFreeSitsAsString() throws Throwable;

	String getFreeSitsAtDateAsString(Date date) throws Throwable;

	String getOrdersAsString(String parameter) throws Throwable;

	String getExecutingOrdersAsString(String parameter) throws Throwable;

	void shiftOrdersTimeExecution(int days) throws Throwable;

	String getMastersAsString(String parameter) throws Throwable;

	String getMastersExecutingConcreteOrderAsString(long id) throws Throwable;

	String getOrderExecutingByConcreteMasterAsString(long id) throws Throwable;

	String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter) throws Throwable;

	String getNearestFreeDateAsString() throws Throwable;

	String getMastersAsString() throws Throwable;

	String getOrdersAsString() throws Throwable;

	String getGaragesAsString() throws Throwable;

	String getSitsAsString() throws Throwable;

	void removeSitFromGarage(Long idSit, Long idGarage) throws Throwable;

	void addOrderToMaster(Long idOrder, Long idMaster) throws Throwable;

	void removeOrderFromMaster(Long idMaster) throws Throwable;

	void addMasterToOrder(Long idMaster, Long idOrder) throws Throwable;

	void removeMasterFromOrder(Long idMaster, Long idOrder) throws Throwable;

	void addOrderToSit(Long idOrder, Long idSit) throws Throwable;

	void removeOrderFromSit(Long idSit) throws Throwable;

	String showFreeMastersOnDate(Date date) throws Throwable;

	void addSitToGarage(Long idGarage, Long idSit) throws Throwable;

}
