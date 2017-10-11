package manager.interfaces;

import storage.*;

public interface IStorageManager {
	GarageStorage getGarageStorage();
	MasterStorage getMasterStorage();
	OrderStorage getOrderStorage();
	SitStorage getSitStorage();
}
