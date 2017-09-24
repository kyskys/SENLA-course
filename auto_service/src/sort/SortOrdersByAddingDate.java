package sort;

import java.util.Comparator;
import java.util.Date;

import entities.Order;

public class SortOrdersByAddingDate implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		Date ad1 = o1.getAddedDate();
		Date ad2 = o2.getAddedDate();
		return ad1.compareTo(ad2);
	}

}
