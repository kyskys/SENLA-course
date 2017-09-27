package controller;

import java.util.Date;

import entities.*;

public interface IController {
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
	public void showMastersExecutingByConcreteOrder(long id);
	public void showOrderExecutingByConcreteMaster(long id);
	public void showOrdersForPeriodOfTime(Date beforeDate, Date afterDate, String parameter);
	public void showNearestFreeDate();
}
