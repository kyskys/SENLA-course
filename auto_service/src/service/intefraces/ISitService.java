package service.intefraces;

import java.util.Date;

import entities.Sit;

public interface ISitService extends IAbstractService<Sit> {
	public String showFreeSits();

	public String showFreeSitsAtDate(Date date);
}
