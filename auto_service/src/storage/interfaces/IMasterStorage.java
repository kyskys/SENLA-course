package storage.interfaces;

import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Order;

public interface IMasterStorage extends ISortableStorage<Master>{
	Order getOrderExecutingByConcreteMaster(Long id);
	List<Master> getFreeMastersOnDate(Date date);
}
