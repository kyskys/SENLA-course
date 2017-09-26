package storage.interfaces;

import entities.Master;
import entities.Order;

public interface IMasterStorage extends IAbstractStorage<Master>{
	Order getOrderExecutingByConcreteMaster(Long id);
}
