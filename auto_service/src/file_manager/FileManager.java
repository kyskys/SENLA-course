package file_manager;

import java.util.List;

import entities.*;
import manager.StorageManager;
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
		List<Master> masters = StorageManager.getMasterStorage().getAll();
		List<Order> orders = StorageManager.getOrderStorage().getAll();
		List<Sit> sits = StorageManager.getSitStorage().getAll();
		List<Garage> garages = StorageManager.getGarageStorage().getAll();
		String[] mastersData = masterFileManager.load();
		String[] ordersData = orderFileManager.load();
		String[] sitsData = sitFileManager.load();
		String[] garagesData = garageFileManager.load();
		for (int i = 0; i < mastersData.length; i++) {
			String[] currentMasterData = mastersData[i].split(" ");
			Master master = new Master(currentMasterData[1]);
			master.setId(Long.valueOf(currentMasterData[0]));
			master.setBusy(Boolean.valueOf(currentMasterData[3]));
			masters.add(master);
		}
		for (int i = 0; i < ordersData.length; i++) {
			String[] currentOrderData = ordersData[i].split(" ");
			Order order = new Order(Double.valueOf(currentOrderData[1]),
					Utils.convertStringToDate(currentOrderData[4]));
			order.setId(Long.valueOf(currentOrderData[0]));
			order.setAddedDate(Utils.convertStringToDate(currentOrderData[2]));
			order.setStartWorkingOnDate(Utils.convertStringToDate(currentOrderData[3]));
			order.setClosed(Boolean.getBoolean(currentOrderData[5]));
			order.setCancelled(Boolean.getBoolean(currentOrderData[6]));
			String[] orderMasters = currentOrderData[7].split(",");
			for (String m : orderMasters) {
				Long id = Long.valueOf(m);
				order.addMaster(StorageManager.getMasterStorage().get(id));
				StorageManager.getMasterStorage().get(id).setOrder(order);
			}
			orders.add(order);
		}
		for (int i = 0; i < garagesData.length; i++) {
			String[] currentGarageData = garagesData[i].split(" ");
			Garage garage = new Garage();
			garage.setId(Long.valueOf(currentGarageData[0]));
			garages.add(garage);
		}
		for (int i = 0; i < sitsData.length; i++) {
			String[] currentSitData = sitsData[i].split(" ");
			Sit sit = new Sit(StorageManager.getGarageStorage().get(Long.valueOf(currentSitData[2])));
			sit.setId(Long.valueOf(currentSitData[0]));
			StorageManager.getGarageStorage().get(Long.valueOf(currentSitData[2])).addSit(sit);
			if (!currentSitData[1].equals("-")) {
				sit.setOrder(StorageManager.getOrderStorage().get(Long.valueOf(currentSitData[1])));
			}
			sits.add(sit);
		}
		StorageManager.recountId(masters, orders, sits, garages);
	}
}
