package service.intefraces;

import java.util.Date;
import java.util.List;

import entities.Sit;

public interface ISitService extends IAbstractService<Sit> {
	public List<Sit> getFreeSits();

	public List<Sit> getFreeSitsAtDate(Date date);

	public void addOrderToSit(Long idOrder, Long idSit);

	public void removeOrderFromSit(Long idSit);
}
