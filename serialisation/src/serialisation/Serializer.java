package serialisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.senla.entities.*;
import com.senla.storage.interfaces.*;
import com.senla.util.IdSequence;

import dependency.DependencyManager;

public class Serializer {
	private List<Master> masters = DependencyManager.getInstance(IMasterStorage.class).getAll();
	private List<Order> orders = DependencyManager.getInstance(IOrderStorage.class).getAll();
	private List<Garage> garages = DependencyManager.getInstance(IGarageStorage.class).getAll();
	private List<Sit> sits = DependencyManager.getInstance(ISitStorage.class).getAll();
	private SerializeUtil util;

	public Serializer(String fileName, String filePath) {
		this.util = new SerializeUtil(fileName, filePath);

	}

	public void save() throws IOException {
		List<Object> list = new ArrayList<Object>();
		list.add(masters);
		list.add(orders);
		list.add(garages);
		list.add(sits);
		util.serializeObject(list);
	}

	@SuppressWarnings("unchecked")
	public void load() {
		List<Object> list;
		try {
			list = (List<Object>) util.deserializeObject();
			masters.addAll((List<Master>) list.get(0));
			orders.addAll((List<Order>) list.get(1));
			garages.addAll((List<Garage>) list.get(2));
			sits.addAll((List<Sit>) list.get(3));
			IdSequence.recountId(masters, orders, garages, sits);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public void updateProperties() throws IOException {
		util.init();
	}
}
