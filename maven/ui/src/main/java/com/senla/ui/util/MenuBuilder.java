package com.senla.ui.util;

import java.io.IOException;
import com.senla.ui.action.order.*;
import com.senla.ui.action.garage.*;
import com.senla.ui.action.master.*;
import com.senla.ui.action.other.*;
import com.senla.ui.action.sit.*;
import com.senla.ui.menu.Menu;
import com.senla.ui.menu.MenuPoint;

import annotation.ConfigProperty;

public class MenuBuilder {
	@ConfigProperty(configName = "config.properties", propertyName = "MenuBuilder.isCreateDeleteSitEnabled", type = boolean.class)
	private boolean isCreateDeleteSitEnabled;
	@ConfigProperty(configName = "config.properties", propertyName = "MenuBuilder.isDeleteOrderEnabled", type = boolean.class)
	private boolean isDeleteOrderEnabled;
	@ConfigProperty(configName = "config.properties", propertyName = "MenuBuilder.isShiftOrderTimeEnabled", type = boolean.class)
	private boolean isShiftOrderTimeEnabled;

	public Menu buildMenu() throws IOException {
		Menu mainMenu = new Menu("main menu");
		// creating all submenus
		Menu garageMenu = new Menu("garage service");
		Menu masterMenu = new Menu("master service");
		Menu orderMenu = new Menu("order service");
		Menu sitMenu = new Menu("sit service");
		Menu otherMenu = new Menu("other");
		// adding all submenus to main
		mainMenu.add(new MenuPoint(garageMenu, "garage menu"));
		mainMenu.add(new MenuPoint(masterMenu, "master menu"));
		mainMenu.add(new MenuPoint(orderMenu, "order menu"));
		mainMenu.add(new MenuPoint(sitMenu, "sit menu"));
		mainMenu.add(new MenuPoint(otherMenu, "other"));
		mainMenu.add(new MenuPoint(null, "exit"));
		// building garage menu
		garageMenu.add(new MenuPoint(garageMenu, "show all garages", new ShowAllGarages()));
		garageMenu.add(new MenuPoint(garageMenu, "create garage", new CreateGarage()));
		garageMenu.add(new MenuPoint(garageMenu, "delete garage", new DeleteGarage()));
		if (isCreateDeleteSitEnabled) {
			garageMenu.add(new MenuPoint(garageMenu, "add sit to garage", new AddSitToGarage()));
			garageMenu.add(new MenuPoint(garageMenu, "remove sit from garage", new RemoveSitFromGarage()));
		}
		garageMenu.add(new MenuPoint(mainMenu, "back"));
		// building master menu
		masterMenu.add(new MenuPoint(masterMenu, "show all masters", new ShowAllMasters()));
		masterMenu.add(new MenuPoint(masterMenu, "show all masters with sort", new ShowAllMastersWithSort()));
		masterMenu.add(new MenuPoint(masterMenu, "create master", new CreateMaster()));
		masterMenu.add(new MenuPoint(masterMenu, "delete master", new DeleteMaster()));
		masterMenu.add(new MenuPoint(masterMenu, "add order to master", new AddOrderToMaster()));
		masterMenu.add(new MenuPoint(masterMenu, "remove order from master", new RemoveOrderFromMaster()));
		masterMenu.add(new MenuPoint(masterMenu, "show free masters on date", new ShowFreeMastersOnDate()));
		masterMenu.add(new MenuPoint(masterMenu, "show order, executing by concrete master",
				new ShowOrderExecutingByConcreteMaster()));
		masterMenu.add(new MenuPoint(mainMenu, "back"));
		// building order menu
		orderMenu.add(new MenuPoint(orderMenu, "show all orders", new ShowAllOrders()));
		orderMenu.add(new MenuPoint(orderMenu, "show all orders with sort", new ShowAllOrdersWithSort()));
		orderMenu.add(new MenuPoint(orderMenu, "create order", new CreateOrder()));
		if (isDeleteOrderEnabled) {
			orderMenu.add(new MenuPoint(orderMenu, "delete order", new DeleteOrder()));
		}
		orderMenu.add(new MenuPoint(orderMenu, "add master to order", new AddMasterToOrder()));
		orderMenu.add(new MenuPoint(orderMenu, "remove master from order", new RemoveMasterFromOrder()));
		orderMenu.add(new MenuPoint(orderMenu, "set order cancelled", new SetOrderCancelled()));
		orderMenu.add(new MenuPoint(orderMenu, "set order closed", new SetOrderClosed()));
		orderMenu.add(new MenuPoint(orderMenu, "show executing orders", new ShowExecutingOrdersWithSort()));
		orderMenu.add(new MenuPoint(orderMenu, "show masters, executing concrete order",
				new ShowMastersExecutingConcreteOrder()));
		orderMenu.add(new MenuPoint(orderMenu, "show nearest free date", new ShowNearestFreeDate()));
		orderMenu.add(new MenuPoint(orderMenu, "show orders for period of time with sort",
				new ShowOrdersForPeriodOfTimeWithSort()));
		if (isShiftOrderTimeEnabled) {
			orderMenu.add(new MenuPoint(orderMenu, "shift order execution time", new ShiftOrderExecutionTime()));
		}
		orderMenu.add(new MenuPoint(mainMenu, "back"));
		// building sit menu
		sitMenu.add(new MenuPoint(sitMenu, "show all sits", new ShowAllSits()));
		sitMenu.add(new MenuPoint(sitMenu, "create sit", new CreateSit()));
		sitMenu.add(new MenuPoint(sitMenu, "delete sit", new DeleteSit()));
		sitMenu.add(new MenuPoint(sitMenu, "add order to sit", new AddOrderToSit()));
		sitMenu.add(new MenuPoint(sitMenu, "remove order from sit", new RemoveOrderFromSit()));
		sitMenu.add(new MenuPoint(sitMenu, "show free sits", new ShowFreeSits()));
		sitMenu.add(new MenuPoint(sitMenu, "show free sits at date", new ShowFreeSitsAtDate()));
		sitMenu.add(new MenuPoint(mainMenu, "back"));
		// building other menu
		otherMenu.add(new MenuPoint(otherMenu, "save data", new SerializeData()));
		otherMenu.add(new MenuPoint(otherMenu, "clone order", new CloneOrder()));
		otherMenu.add(new MenuPoint(otherMenu, "export entity", new ExportEntity()));
		otherMenu.add(new MenuPoint(otherMenu, "import entity", new ImportEntity()));
		otherMenu.add(new MenuPoint(mainMenu, "back"));
		return mainMenu;
	}

}
