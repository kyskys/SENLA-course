package service.intefraces;

import entities.Master;
import entities.Order;

public interface IMasterService extends ISortableService<Master> {

	public Order getOrderExecutingByConcreteMaster(Long id);
}
