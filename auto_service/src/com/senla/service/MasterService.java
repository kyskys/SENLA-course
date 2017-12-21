package com.senla.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	private static final String GET_ORDER_EXECUTING_BY_CONCRETE_MASTER = "select * from auto_service_db.order where order_id=(select order_id from auto_service_db.master where master_id=?";

	@Override
	public ISortableStorage<Master> getStorage() {
		return masterStorage;
	}

	@Override
	public Order getOrderExecutingByConcreteMaster(Long id) throws SQLException {
		try (PreparedStatement statement = getConnection().prepareStatement(GET_ORDER_EXECUTING_BY_CONCRETE_MASTER)) {
			statement.setLong(0, id);
			ResultSet rs = statement.executeQuery();
			
		}
	}

	@Override
	public List<Master> getFreeMastersOnDate(Date date) {
		return masterStorage.getFreeMastersOnDate(date);
	}

	@Override
	public synchronized void addOrderToMaster(Long idOrder, Long idMaster) {
		Master master = masterStorage.get(idMaster);
		Order order = orderStorage.get(idOrder);
		if (!order.getMasters().contains(master)) {
			master.setOrder(order);
			order.addMaster(master);
		}
	}

	@Override
	public synchronized void removeOrderFromMaster(Long idMaster) {
		Master master = masterStorage.get(idMaster);
		master.getOrder().removeMaster(master);
		master.setOrder(null);

	}

}
