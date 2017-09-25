package storage;

import java.util.List;

import entities.Order;
import sort.SortOrdersByAddedDate;
import sort.SortOrdersByEndingDate;
import sort.SortOrdersByPrice;
import sort.SortOrdersByStartWorkingOnDate;
import sort.SortParameters;

public class OrderStorage extends SortableStorage<Order> {

	@Override
	protected boolean sort(List<Order> listToSort, SortParameters sp) {
		switch (sp) {
		case ADDED_DATE: {
			listToSort.sort(new SortOrdersByAddedDate());
			break;
		}
		case ENDING_DATE: {
			listToSort.sort(new SortOrdersByEndingDate());
			break;
		}
		case PRICE: {
			listToSort.sort(new SortOrdersByPrice());
			break;
		}
		case START_WORKING_ON_DATE: {
			listToSort.sort(new SortOrdersByStartWorkingOnDate());
			break;
		}
		default:
			return false;
		}
		return true;
	}

}
