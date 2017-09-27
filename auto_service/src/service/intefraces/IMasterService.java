package service.intefraces;

import entities.Master;

public interface IMasterService extends ISortableService<Master> {
	public String showMasters(String parameter);

	public String showOrderExecutingByConcreteMaster(Long id);
}
