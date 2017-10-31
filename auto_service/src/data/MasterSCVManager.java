package data;

import com.senla.entities.BaseEntity;
import com.senla.entities.Master;
import com.senla.service.interfaces.IMasterService;

import annotation.Injectable;

public class MasterSCVManager extends AbstractCSVManager<Master> implements ISCVManager<Master> {
	@Injectable
	private IMasterService masterService;

	@Override
	public void importSCV(String data) {
		String[] currentMasterData = data.split(" ");
		Long idMaster = Long.valueOf(currentMasterData[0]);
		Master master;
		if (masterService.get(idMaster) == null) {
			master = new Master(null);
			master.setId(idMaster);
			masterService.create(master);
		} else {
			master = masterService.get(idMaster);
		}
		master.setName(currentMasterData[1]);
		master.setBusy(Boolean.valueOf(currentMasterData[3]));
		masterService.addOrderToMaster(Long.valueOf(currentMasterData[4]), idMaster);
	}

	@Override
	public String[] exportSCV() {
		return getListAsArray(masterService.getAll());
	}

	@Override
	public String convertEntityToCSVString(Master entity) {
		return String.format("%s %s %s %s", entity.getId(), entity.getName(), entity.isBusy(),
				BaseEntity.getIdAsString(entity.getOrder()));
	}

}