package com.senla.service;

import java.sql.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.service.interfaces.*;
import com.senla.storage.interfaces.IMasterStorage;
import com.senla.storage.interfaces.IOrderStorage;
import com.senla.storage.interfaces.ISortableStorage;

import annotation.Injectable;

public class MasterService extends SortableService<Master> implements IMasterService {
	@Injectable
	private IMasterStorage masterStorage;
	@Injectable
	private IOrderStorage orderStorage;

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) {
		return executeAction(manager -> {
			return masterStorage.getOrderExecutingByConcreteMaster(manager, id);
		});
	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) {
		return (List<Master>) executeAction(manager -> {
			return masterStorage.getFreeMastersOnDate(manager, date);
		});

	}

	@Override
	public synchronized void addOrderToMaster(Long idOrder, Long idMaster) {
		executeSimpleTransactionAction(manager -> {
			Master master = masterStorage.get(manager, idMaster);
			Order order = orderStorage.get(manager, idOrder);
			master.setOrder(order);
			order.addMaster(master);
			masterStorage.update(manager, master);
			orderStorage.update(manager, order);
		});
	}

	@Override
	public synchronized void removeOrderFromMaster(Long idMaster) {
		executeSimpleTransactionAction(manager -> {
			Master master = masterStorage.get(manager, idMaster);
			Order order = master.getOrder();
			master.setOrder(null);
			order.removeMaster(master);
			masterStorage.update(manager, master);
			orderStorage.update(manager, order);
		});
	}

}
