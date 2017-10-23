package controller;

import java.util.Date;

import entities.*;

public interface IController {
	public Garage getGarage(long id);

	public Master getMaster(long id);

	public Order getOrder(long id);

	public Sit getSit(long id);

	public void addMaster(Master master);

	public void removeMaster(long id);

	public void addOrder(Order order);

	public void removeOrder(long id);

	public void setOrderClosed(long id);

	public void setOrderCancelled(long id);

	public void addGarage(Garage garage);

	public void removeGarage(long id);

	public void addSit(Sit sit);

	public void removeSit(long id);

	public String getFreeSitsAsString();

	public String getFreeSitsAtDateAsString(Date date);

	public String getOrdersAsString(String parameter);

	public String getExecutingOrdersAsString(String parameter);

	public void shiftOrdersTimeExecution(int days);

	public String getMastersAsString(String parameter);

	public String getMastersExecutingConcreteOrderAsString(long id);

	public String getOrderExecutingByConcreteMasterAsString(long id);

	public String getOrdersForPeriodOfTimeAsString(Date beforeDate, Date afterDate, String parameter);

	public String getNearestFreeDateAsString();

	public String getMastersAsString();

	public String getOrdersAsString();

	public String getGaragesAsString();

	public String getSitsAsString();

	public void addSitToGarage(Long idGarage);

	public void removeSitFromGarage(Long idSit, Long idGarage);

	public void addOrderToMaster(Long idOrder, Long idMaster);

	public void removeOrderFromMaster(Long idMaster);

	public void addMasterToOrder(Long idMaster, Long idOrder);

	public void removeMasterFromOrder(Long idMaster, Long idOrder);

	public void addOrderToSit(Long idOrder, Long idSit);

	public void removeOrderFromSit(Long idSit);
	
	public String showFreeMastersOnDate(Date date);

}
