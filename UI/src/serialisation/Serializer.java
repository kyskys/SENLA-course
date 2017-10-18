package serialisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.*;
import manager.interfaces.IStorageManager;

public class Serializer {
	public static List<Master> masters;
	public static List<Order> orders;
	public static List<Garage> garages;
	public static List<Sit> sits;

	public Serializer(IStorageManager storages) {
		masters = storages.getMasterStorage().getAll();
		orders = storages.getOrderStorage().getAll();
		garages = storages.getGarageStorage().getAll();
		sits = storages.getSitStorage().getAll();
	}

	public void save() throws IOException {
		List<Object> list = new ArrayList<Object>();
		list.add(masters);
		list.add(orders);
		list.add(garages);
		list.add(sits);
			SerializeUtil.serializeObject(list);
	}

	@SuppressWarnings("unchecked")
	public void load() throws ClassNotFoundException, IOException {
		List<Object> list;
		try {
			list = (List<Object>) SerializeUtil.deserializeObject();
			masters = (List<Master>) list.get(0);
			orders = (List<Order>) list.get(1);
			garages = (List<Garage>) list.get(2);
			sits = (List<Sit>) list.get(3);
		} catch (Throwable e) {
			masters = new ArrayList<Master>();
			orders = new ArrayList<Order>();
			garages = new ArrayList<Garage>();
			sits = new ArrayList<Sit>();
		}
	}
}
