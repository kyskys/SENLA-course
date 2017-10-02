package file_manager;

import entities.BaseEntity;
import entities.Master;

public class MasterFileManager extends AbstractFileManager<Master> {

	public MasterFileManager(String filePath) {
		super(filePath);
	}

	@Override
	public String ConvertEntityToString(Master entity) {
		return entity.getId() + " " + entity.getName() + " " + BaseEntity.getIdAsString(entity.getOrder()) + " " + entity.isBusy();
	}

}
