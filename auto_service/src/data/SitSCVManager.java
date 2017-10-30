package data;

import com.senla.entities.Sit;
import com.senla.service.interfaces.ISitService;

import annotation.Injectable;

public class SitSCVManager implements ISCVManager<Sit> {
	@Injectable
	private ISitService sitService;

	@Override
	public void importSCV(String data) {
		String[] currentSitData = data.split(" ");
		Long idSit = Long.valueOf(currentSitData[0]);
		Sit sit;
		if (sitService.get(idSit) == null) {
			sit = new Sit(null);
			sit.setId(idSit);
			sitService.create(sit);
		} else {
			sit = sitService.get(idSit);
		}
		if (!currentSitData[1].equals("-")) {
			sitService.addOrderToSit(Long.valueOf(currentSitData[1]), idSit);
		}
		sitService.addGarageToSit(Long.valueOf(currentSitData[2]), idSit);
	}

	@Override
	public String exportSCV(Sit entity) {
		return entity.toString();
	}

}