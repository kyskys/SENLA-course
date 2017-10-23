package data;

import java.util.List;

import entities.*;
import manager.StorageManager;
import manager.interfaces.IStorageManager;
import util.Utils;

public class DataManager {
	private GarageDataManager garageFileManager;
	private OrderDataManager orderFileManager;
	private SitDataManager sitFileManager;
	private MasterDataManager masterFileManager;
	private IStorageManager storageManager;

	public DataManager(IStorageManager storageManager, String garageFilePath, String masterFilePath,
			String orderFilePath, String sitFilePath) {
		this.storageManager = storageManager;
		garageFileManager = new GarageDataManager(garageFilePath);
		orderFileManager = new OrderDataManager(orderFilePath);
		sitFileManager = new SitDataManager(sitFilePath);
		masterFileManager = new MasterDataManager(masterFilePath);
	}

	public void save() {
		garageFileManager.save(storageManager.getGarageStorage().getAll());
		orderFileManager.save(storageManager.getOrderStorage().getAll());
		sitFileManager.save(storageManager.getSitStorage().getAll());
		masterFileManager.save(storageManager.getMasterStorage().getAll());
	}

	public void load() {
		List<Master> masters = storageManager.getMasterStorage().getAll();
		List<Order> orders = storageManager.getOrderStorage().getAll();
		List<Sit> sits = storageManager.getSitStorage().getAll();
		List<Garage> garages = storageManager.getGarageStorage().getAll();
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
			Order order = new Order(Double.valueOf(currentOrderData[1]), Utils.convertStringToDate(currentOrderData[4]),
					Utils.convertStringToDate(currentOrderData[3]));
			order.setId(Long.valueOf(currentOrderData[0]));
			order.setAddedDate(Utils.convertStringToDate(currentOrderData[2]));
			order.setStartWorkingOnDate(Utils.convertStringToDate(currentOrderData[3]));
			order.setClosed(Boolean.getBoolean(currentOrderData[5]));
			order.setCancelled(Boolean.getBoolean(currentOrderData[6]));
			if (currentOrderData[7] != null) {
				String[] orderMasters = currentOrderData[7].split(",");
				for (String m : orderMasters) {
					Long id = Long.valueOf(m);
					Master master = storageManager.getMasterStorage().get(id);
					order.addMaster(master);
					master.setOrder(order);
				}
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
			Garage garage = storageManager.getGarageStorage().get(Long.valueOf(currentSitData[2]));
			Sit sit = new Sit(garage);
			sit.setId(Long.valueOf(currentSitData[0]));
			garage.addSit(sit);
			if (!currentSitData[1].equals("-")) {
				sit.setOrder(storageManager.getOrderStorage().get(Long.valueOf(currentSitData[1])));
			}
			sits.add(sit);
		}
		StorageManager.recountId(masters, orders, sits, garages);
	}
}