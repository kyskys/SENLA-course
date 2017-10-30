package com.senla.service;

import java.util.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.service.interfaces.IMasterService;
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
		return masterStorage.getOrderExecutingByConcreteMaster(id);
	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) {
		return masterStorage.getFreeMastersOnDate(date);
	}

	@Override
	public void addOrderToMaster(Long idOrder, Long idMaster) {
		Master master = masterStorage.get(idMaster);
		Order order = orderStorage.get(idOrder);
		master.setOrder(order);
		order.addMaster(master);
	}

	@Override
	public void removeOrderFromMaster(Long idMaster) {
		Master master = masterStorage.get(idMaster);
		master.getOrder().removeMaster(master);
		master.setOrder(null);

	}

}
