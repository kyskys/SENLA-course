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

	public void showFreeSits();

	public void showFreeSitsAtDate(Date date);

	public void showOrders(String parameter);

	public void showExecutingOrders(String parameter);

	public void shiftOrdersTimeExecution(int days);

	public void showMasters(String parameter);

	public void showMastersExecutingConcreteOrder(long id);

	public void showOrderExecutingByConcreteMaster(long id);

	public void showOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter);

	public void showNearestFreeDate();

	public void showMasters();

	public void showOrders();

	public void showGarages();

	public void showSits();

	public void addSitToGarage(Long idGarage);

	public void removeSitFromGarage(Long idSit, Long idGarage);

	public void addOrderToMaster(Long idOrder, Long idMaster);

	public void removeOrderFromMaster(Long idMaster);

	public void addMasterToOrder(Long idMaster, Long idOrder);

	public void removeMasterFromOrder(Long idMaster, Long idOrder);

	public void addOrderToSit(Long idOrder, Long idSit);

	public void removeOrderFromSit(Long idSit);

}
