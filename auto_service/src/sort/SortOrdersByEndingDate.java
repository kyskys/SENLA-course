package sort;

import java.util.Date;
import java.util.Comparator;

import entities.Order;

public class SortOrdersByEndingDate implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		Date d1 = o1.getEndingDate();
		Date d2 = o2.getEndingDate();
		return d1.compareTo(d2);
	}

}
