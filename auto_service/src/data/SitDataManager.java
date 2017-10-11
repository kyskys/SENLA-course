package data;

import entities.BaseEntity;
import entities.Sit;

public class SitDataManager extends AbstractDataManager<Sit> {
	public SitDataManager(String filePath) {
		super(filePath);
	}

	@Override
	public String convertEntityToString(Sit entity) {
		return entity.getId() + " " + BaseEntity.getIdAsString(entity.getOrder()) + " "
				+ BaseEntity.getIdAsString(entity.getGarage());
	}
}
