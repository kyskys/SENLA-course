package file_manager;

import entities.Garage;

public class GarageFileManager extends AbstractFileManager<Garage> {
	public GarageFileManager(String filePath) {
		super(filePath);
	}

	@Override
	public String ConvertEntityToString(Garage entity) {
		return entity.getId() + " " + ConvertListToString(entity.getSits());
	}
}
