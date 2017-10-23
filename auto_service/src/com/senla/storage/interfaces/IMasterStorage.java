package com.senla.storage.interfaces;

import java.util.Date;
import java.util.List;

import com.senla.entities.Master;
import com.senla.entities.Order;

public interface IMasterStorage extends ISortableStorage<Master>{
	Order getOrderExecutingByConcreteMaster(Long id);
	List<Master> getFreeMastersOnDate(Date date);
}
