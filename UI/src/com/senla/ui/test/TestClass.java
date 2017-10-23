package com.senla.ui.test;

import java.util.Date;

import com.senla.entities.Master;
import com.senla.entities.Order;

public class TestClass {

	public static void main(String[] args) {
		Master master = new Master("tosik");
		Master master1 = new Master("pesik");
		Order order = new Order(10, new Date(10000), new Date(412411));
		order.addMaster(master);
		Order clone = order.clone();
		clone.setAddedDate(new Date(33333));
		clone.setCancelled(true);
		clone.setPrice(0);
		clone.addMaster(master1);
		System.out.println(order);
		System.out.println(clone);
	}
}
