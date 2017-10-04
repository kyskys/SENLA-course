package service.intefraces;

import java.util.Date;
import java.util.List;

import entities.Master;
import entities.Order;

public interface IMasterService extends ISortableService<Master> {

	public Order getOrderExecutingByConcreteMaster(Long id);

	public List<Master> getFreeMastersOnDate(Date date);

	public void addOrderToMaster(Long idOrder, Long idMaster);

	public void removeOrderFromMaster(Long idMaster);
}
