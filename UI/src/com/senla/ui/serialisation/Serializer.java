package com.senla.ui.serialisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.senla.entities.*;
import com.senla.manager.interfaces.IStorageManager;
import com.senla.util.IdSequence;

import serialisation.SerializeUtil;

public class Serializer {
	private List<Master> masters;
	private List<Order> orders;
	private List<Garage> garages;
	private List<Sit> sits;
	private SerializeUtil util;

	public Serializer(IStorageManager storages, String fileName, String filePath) {
		this.masters = storages.getMasterStorage().getAll();
		this.orders = storages.getOrderStorage().getAll();
		this.garages = storages.getGarageStorage().getAll();
		this.sits = storages.getSitStorage().getAll();
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
	public void load() throws ClassNotFoundException, IOException {
		List<Object> list;
		list = (List<Object>) util.deserializeObject();
		masters.addAll((List<Master>) list.get(0));
		orders.addAll((List<Order>) list.get(1));
		garages.addAll((List<Garage>) list.get(2));
		sits.addAll((List<Sit>) list.get(3));
		IdSequence.recountId(masters, orders, garages, sits);
	}

	public void updateProperties() throws IOException {
		util.init();
	}
}
