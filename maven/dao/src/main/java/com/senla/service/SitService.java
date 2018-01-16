package com.senla.service;

import java.sql.Date;
import java.sql.SQLException;
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
	public List<Sit> getFreeSits() throws SQLException {
		return executeTransactionAction(manager -> {
			return sitStorage.getFreeSits(manager);
		});
	}

	@Override
	public List<Sit> getFreeSitsAtDate(Date date) throws SQLException {
		return executeTransactionAction(manager -> {
			return sitStorage.getFreeSitsAtDate(manager, date);
		});
	}

	@Override
	public synchronized void addOrderToSit(Long idOrder, Long idSit) throws SQLException {
		executeSimpleTransactionAction(manager -> {
			Order order = orderStorage.get(manager, idOrder);
			Sit sit = sitStorage.get(manager, idSit);
			order.setSit(sit);
			sit.setOrder(order);
			sitStorage.update(manager, sit);
			orderStorage.update(manager, order);
		});
	}

	@Override
	public synchronized void removeOrderFromSit(Long idSit) throws SQLException {
		executeSimpleTransactionAction(manager -> {
			Sit sit = sitStorage.get(manager, idSit);
			Order order = sit.getOrder();
			order.setSit(null);
			sit.setOrder(null);
			sitStorage.update(manager, sit);
			orderStorage.update(manager, order);
		});
	}

	@Override
	public synchronized void addGarageToSit(Long idGarage, Long idSit) throws SQLException {
		executeSimpleTransactionAction(manager -> {
			Garage garage = garageStorage.get(manager, idGarage);
			Sit sit = sitStorage.get(manager, idSit);
			garage.addSit(sit);
			sit.setGarage(garage);
			sitStorage.update(manager, sit);
			garageStorage.update(manager, garage);
		});
	}

	@Override
	public synchronized void removeGarageFromSit(Long idGarage, Long idSit) throws SQLException {
		executeSimpleTransactionAction(manager -> {
			Garage garage = garageStorage.get(manager, idGarage);
			Sit sit = sitStorage.get(manager, idSit);
			garage.removeSit(sit);
			sit.setGarage(null);
			sitStorage.update(manager, sit);
			garageStorage.update(manager, garage);
		});
	}
}
