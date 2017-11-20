package com.senla.service;

import java.util.Date;
import java.util.List;

import com.senla.entities.Garage;
import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.service.interfaces.ISitService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IGarageStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISitStorage;

import annotation.Injectable;

public class SitService extends AbstractService<Sit> implements ISitService {
	@Injectable
	private ISitStorage sitStorage;
	@Injectable
	private IOrderStorage orderStorage;
	@Injectable
	private IGarageStorage garageStorage;

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
	public synchronized void addOrderToSit(Long idOrder, Long idSit) {
		Order order = orderStorage.get(idOrder);
		Sit sit = sitStorage.get(idSit);
		sit.setOrder(order);
	}

	@Override
	public synchronized void removeOrderFromSit(Long idSit) {
		Sit sit = sitStorage.get(idSit);
		sit.setOrder(null);
	}

	@Override
	public synchronized void addGarageToSit(Long idGarage, Long idSit) {
		Sit sit = sitStorage.get(idSit);
		Garage garage = garageStorage.get(idGarage);
		sit.setGarage(garage);
		garage.addSit(sit);
	}

	@Override
	public synchronized void removeGarageFromSit(Long idGarage, Long idSit) {
		Sit sit = sitStorage.get(idSit);
		Garage garage = garageStorage.get(idGarage);
		garage.removeSit(sit);
		sit.setGarage(null);
	}

}
