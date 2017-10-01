package manager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.*;
import util.Utils;

public class FileManager {
	GarageFileManager garageFileManager = new GarageFileManager();
	OrderFileManager orderFileManager = new OrderFileManager();
	SitFileManager sitFileManager = new SitFileManager();
	MasterFileManager masterFileManager = new MasterFileManager();

	public void save() {
		garageFileManager.save(StorageManager.getGarageStorage().getAll());
		orderFileManager.save(StorageManager.getOrderStorage().getAll());
		sitFileManager.save(StorageManager.getSitStorage().getAll());
		masterFileManager.save(StorageManager.getMasterStorage().getAll());
	}

	public void load() {
		List<Master> masters = new ArrayList<Master>();
		List<Order> orders = new ArrayList<Order>();
		List<Sit> sits = new ArrayList<Sit>();
		List<Garage> garages = new ArrayList<Garage>();
		String[] mastersData = masterFileManager.load();
		String[] ordersData = orderFileManager.load();
		String[] sitsData = sitFileManager.load();
		String[] garagesData = garageFileManager.load();
		for (int i = 0; i < mastersData.length; i++) {
			String[] currentMasterData = mastersData[i].split(" ");
			Master master = new Master(currentMasterData[1]);
			master.setId(Long.valueOf(currentMasterData[0]));
			master.setBusy(Boolean.valueOf(currentMasterData[3]));
		}
		for (int i = 0; i < ordersData.length; i++) {
			String[] currentOrderData = ordersData[i].split(" ");
			Order order = new Order(Double.valueOf(currentOrderData[1]),Date.valueOf(currentOrderData[4]));
			order.setAddedDate(Utils.convertStringToDate(currentOrderData[2]));
			order.setStartWorkingOnDate(Utils.convertStringToDate(currentOrderData[3]));
			order.setClosed(Boolean.getBoolean(currentOrderData[5]));
			order.setCancelled(Boolean.getBoolean(currentOrderData[6]));
			String[]masters = currentOrderData[7].split(",");
		}
	}
}
