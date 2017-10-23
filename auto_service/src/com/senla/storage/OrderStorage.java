package com.senla.storage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.sort.SortOrdersByAddedDate;
import com.senla.sort.SortOrdersByEndingDate;
import com.senla.sort.SortOrdersByPrice;
import com.senla.sort.SortOrdersByStartWorkingOnDate;
import com.senla.sort.SortParameters;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.util.Utils;

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
		listToSort.sort(Utils.nullSafeCompare(comparator));
	}

	@Override
	public List<Master> getMastersExecutingConcreteOrder(Long id) {
		return get(id).getMasters();
	}

	@Override
	public List<Order> getExecutingOrders(SortParameters parameter) {
		List<Order> result = new ArrayList<Order>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStartWorkingOnDate().before(new Date())) {
				result.add(list.get(i));
			}
		}
		sort(result, parameter);
		return result;
	}

	@Override
	public List<Order> getOrdersForPeriodOfTime(Date beforeDate, Date afterDate, SortParameters parameter) {
		List<Order> result = new ArrayList<Order>();
		for (int i = 0; i < list.size(); i++) {
			Order order = list.get(i);
			if (order.getEndingDate().before(afterDate) || order.getStartWorkingOnDate().after(beforeDate)) {
				if (order.isCancelled() || order.isClosed()) {
					result.add(order);
				}
			}
		}
		sort(result, parameter);
		return result;
	}

	@Override
	public void setOrderCancelled(Long id) {
		get(id).setCancelled(true);
	}

	@Override
	public void setOrderClosed(Long id) {
		get(id).setClosed(true);
	}

	@Override
	public Date showNearestDate() {
		Date result = list.get(0).getEndingDate();
		for (Order order : list) {
			if (result.compareTo(order.getEndingDate()) > 0) {
				result = order.getEndingDate();
			}
		}
		return result;
	}

}
