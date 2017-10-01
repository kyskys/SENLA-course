package file_manager;

import entities.BaseEntity;
import entities.Sit;

public class SitFileManager extends AbstractFileManager<Sit> {
	public SitFileManager() {
		super("Sits.txt");
	}

	@Override
	public String ConvertEntityToString(Sit entity) {
		return entity.getId() + " " + BaseEntity.getIdAsString(entity.getOrder()) + " "
				+ BaseEntity.getIdAsString(entity.getGarage());
	}
}
