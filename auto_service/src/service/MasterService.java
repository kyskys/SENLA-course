package service;

import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Order;
import service.intefraces.IMasterService;
import storage.interfaces.IMasterStorage;
import storage.interfaces.IOrderStorage;
import storage.interfaces.ISortableStorage;

public class MasterService extends SortableService<Master> implements IMasterService {
	private IMasterStorage masterStorage;
	private IOrderStorage orderStorage;

	public MasterService(IMasterStorage masterStorage, IOrderStorage orderStorage) {
		this.masterStorage = masterStorage;
		this.orderStorage = orderStorage;
	}

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
