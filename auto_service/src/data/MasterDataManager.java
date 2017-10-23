package data;

import entities.BaseEntity;
import entities.Master;

public class MasterDataManager extends AbstractDataManager<Master> {

	public MasterDataManager(String filePath) {
		super(filePath);
	}

	@Override
	public String convertEntityToString(Master entity) {
		return entity.getId() + " " + entity.getName() + " " + BaseEntity.getIdAsString(entity.getOrder()) + " "
				+ entity.isBusy();
	}

}