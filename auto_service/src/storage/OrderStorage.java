package storage;

import java.util.Comparator;
import java.util.List;

import entities.Order;
import sort.SortOrdersByAddedDate;
import sort.SortOrdersByEndingDate;
import sort.SortOrdersByPrice;
import sort.SortOrdersByStartWorkingOnDate;
import sort.SortParameters;
import storage.interfaces.IOrderStorage;

public class OrderStorage extends SortableStorage<Order> implements IOrderStorage {

	@Override
	protected void sort(List<Order> listToSort, SortParameters sp) {

		Comparator<Order> comparator = null;
		switch (sp) {
		case ADDED_DATE: {
			comparator = new SortOrdersByAddedDate();
			break;
		}
		case ENDING_DATE: {
			comparator = new SortOrdersByEndingDate();
			break;
		}
		case PRICE: {
			comparator = new SortOrdersByPrice();
			break;
		}
		case START_WORKING_ON_DATE: {
			comparator = new SortOrdersByStartWorkingOnDate();
			break;
		}
		default:
			return;
		}
		listToSort.sort(comparator);
	}

}
