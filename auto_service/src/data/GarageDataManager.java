package data;

import entities.Garage;

public class GarageDataManager extends AbstractDataManager<Garage> {
	public GarageDataManager(String filePath) {
		super(filePath);
	}

	@Override
	public String ConvertEntityToString(Garage entity) {
		return entity.getId() + " " + ConvertListToString(entity.getSits());
	}
}
