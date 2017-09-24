package storage;

import java.util.ArrayList;
import java.util.List;

import entities.BaseEntity;
import entities.Order;
import sort.SortOrdersByAddedDate;
import sort.SortOrdersByEndingDate;
import sort.SortOrdersByPrice;
import sort.SortOrdersByStartWorkingOnDate;
import sort.SortParameters;
import sort.Sortable;

public class OrderStorage implements IStorage, Sortable {
	private List<Order> orders = new ArrayList<Order>();

	@Override
	public boolean sort(SortParameters sp) {
		boolean b = true;
		switch (sp) {
		case ADDED_DATE: {
			orders.sort(new SortOrdersByAddedDate());
			break;
		}
		case ENDING_DATE: {
			orders.sort(new SortOrdersByEndingDate());
			break;
		}
		case PRICE: {
			orders.sort(new SortOrdersByPrice());
			break;
		}
		case START_WORKING_ON_DATE: {
			orders.sort(new SortOrdersByStartWorkingOnDate());
			break;
		}
		default:
			b = false;
			break;
		}
		return b;
	}

	@Override
	public boolean add(BaseEntity be) {
		return orders.add((Order) be);
	}

	@Override
	public boolean remove(BaseEntity be) {
		return orders.remove(be);
	}

	public List<Order> getOrders() {
		return orders;
	}

}
