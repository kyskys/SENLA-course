package com.senla.service;

import java.util.Date;
import java.util.List;

import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.service.intefraces.ISitService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISitStorage;

public class SitService extends AbstractService<Sit> implements ISitService {
	private ISitStorage sitStorage;
	private IOrderStorage orderStorage;

	public SitService(ISitStorage sitStorage, IOrderStorage orderStorage) {
		this.orderStorage = orderStorage;
		this.sitStorage = sitStorage;
	}

	@Override
	public IAbstractStorage<Sit> getStorage() {
		return sitStorage;
	}

	@Override
	public List<Sit> getFreeSits() {
		return sitStorage.getFreeSitsOnDate(new Date());
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) {
		return sitStorage.getFreeSitsOnDate(date);
	}

	@Override
	public void addOrderToSit(Long idOrder, Long idSit) {
		Order order = orderStorage.get(idOrder);
		Sit sit = sitStorage.get(idSit);
		sit.setOrder(order);
	}

	@Override
	public void removeOrderFromSit(Long idSit) {
		Sit sit = sitStorage.get(idSit);
		sit.setOrder(null);
	}

}
