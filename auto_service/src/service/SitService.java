package service;

import java.util.Date;
import java.util.List;

import entities.Order;
import entities.Sit;
import manager.StorageManager;
import service.intefraces.ISitService;
import storage.OrderStorage;
import storage.SitStorage;
import storage.interfaces.IAbstractStorage;

public class SitService extends AbstractService<Sit> implements ISitService {
	private SitStorage sitStorage = StorageManager.getSitStorage();
	private OrderStorage orderStorage = StorageManager.getOrderStorage();

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
