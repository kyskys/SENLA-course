package controller;

import java.util.Date;

public interface IController {
	public void addMaster();
	public void removeMaster(long id);
	public void addOrder();
	public void removeOrder(long id);
	public void setOrderClosed(long id);
	public void setOrderCancelled(long id);
	public void addGarage();
	public void removeGarage(long id);
	public void addSit();
	public void removeSit(long id);
	public void getFreeSits();
	public void showOrders(String paramerter);
	public void showMasters(String parameter);
	public void showExecutingOrders(String parameter);
	public void showMastersExecutingByConcreteOrder(long id);
	public void showOrderExecutingByConcreteMaster(long id);
	public void showOrdersForPeriodOfTime(Date dateBefore, Date DateAfter, String parameter);
	public void showFreeSitsAtDate(Date date);
	public void showNearestFreeDate();
	public void shiftOrdersTimeExecution(int days);
}
