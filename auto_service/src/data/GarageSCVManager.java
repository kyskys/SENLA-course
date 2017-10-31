package data;

import com.senla.entities.Garage;
import com.senla.service.interfaces.IGarageService;

import annotation.Injectable;

public class GarageSCVManager extends AbstractCSVManager<Garage> implements ISCVManager<Garage> {
	@Injectable
	private IGarageService garageService;

	@Override
	public void importSCV(String data) {
		String[] currentGarageData = data.split(" ");
		Long idGarage = Long.valueOf(currentGarageData[0]);
		Garage garage;
		if (garageService.get(idGarage) == null) {
			garage = new Garage();
			garage.setId(idGarage);
			garageService.create(garage);
		} else {
			garage = garageService.get(idGarage);
		}
		String[] sits = currentGarageData[1].split(",");
		for (String idSit : sits) {
			garageService.addSitToGarage(idGarage, Long.valueOf(idSit));
		}
	}

	@Override
	public String[] exportSCV() {
		return getListAsArray(garageService.getAll());
	}

	@Override
	public String convertEntityToCSVString(Garage entity) {
		return String.format("%s %s", entity.getId(), convertListToCSVString(entity.getSits()));
	}
}