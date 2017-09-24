package sort;

import java.util.Comparator;

import entities.Order;

public class SortOrdersByPrice implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		Double p1 = o1.getPrice();
		Double p2 = o2.getPrice();
		return p1.compareTo(p2);
	}

}
