package main;

import java.util.Date;
import java.util.List;

import com.senla.entities.Sit;
import com.senla.service.interfaces.IAbstractService;

public interface ISitService extends IAbstractService<Sit> {
	public List<Sit> getFreeSits();

	public List<Sit> getFreeSitsAtDate(Date date);

	public void addOrderToSit(Long idOrder, Long idSit);

	public void removeOrderFromSit(Long idSit);
}
