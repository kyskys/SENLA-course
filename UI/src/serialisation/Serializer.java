package serialisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.*;
import manager.interfaces.IStorageManager;
import util.IdSequence;

public class Serializer {
	private static List<Master> masters;
	private static List<Order> orders;
	private static List<Garage> garages;
	private static List<Sit> sits;

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
		list = (List<Object>) SerializeUtil.deserializeObject();
		masters.addAll((List<Master>) list.get(0));
		orders.addAll((List<Order>) list.get(1));
		garages.addAll((List<Garage>) list.get(2));
		sits.addAll((List<Sit>) list.get(3));
		IdSequence.recountId(masters, orders, garages, sits);
	}
}
