package com.senla.sort;

import java.util.Comparator;
import java.util.Date;

import com.senla.entities.Order;

public class SortOrdersByStartWorkingOnDate implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		Date d1 = o1.getStartWorkingOnDate();
		Date d2 = o1.getStartWorkingOnDate();
		return d1.compareTo(d2);
	}

}
