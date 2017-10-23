package com.senla.manager.interfaces;

import com.senla.storage.*;

public interface IStorageManager {
	GarageStorage getGarageStorage();
	MasterStorage getMasterStorage();
	OrderStorage getOrderStorage();
	SitStorage getSitStorage();
}
