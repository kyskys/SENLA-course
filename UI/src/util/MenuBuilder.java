package util;

import java.io.IOException;

import action.garage.*;
import action.master.*;
import action.order.*;
import action.other.CloneOrder;
import action.sit.*;
import config.AutoServiceConfig;
import controller.IController;
import menu.Menu;
import menu.MenuPoint;

public class MenuBuilder {
	public static Menu buildMenu(IController controller) throws IOException {
		Menu mainMenu = new Menu("main menu");
		// creating all submenus
		Menu garageMenu = new Menu("garage service");
		Menu masterMenu = new Menu("master service");
		Menu orderMenu = new Menu("order service");
		Menu sitMenu = new Menu("sit service");
		Menu otherMenu = new Menu("other");
		// adding all submenus to main
		mainMenu.add(new MenuPoint(controller, garageMenu, "garage menu"));
		mainMenu.add(new MenuPoint(controller, masterMenu, "master menu"));
		mainMenu.add(new MenuPoint(controller, orderMenu, "order menu"));
		mainMenu.add(new MenuPoint(controller, sitMenu, "sit menu"));
		mainMenu.add(new MenuPoint(null, null, "exit"));
		// building garage menu
		garageMenu.add(new MenuPoint(controller, garageMenu, "show all garages", new ShowAllGarages()));
		garageMenu.add(new MenuPoint(controller, garageMenu, "create garage", new CreateGarage()));
		garageMenu.add(new MenuPoint(controller, garageMenu, "delete garage", new DeleteGarage()));
		if (AutoServiceConfig.getInstance().isCreateDeleteSitEnabled()) {
			garageMenu.add(new MenuPoint(controller, garageMenu, "add sit to garage", new AddSitToGarage()));
			garageMenu.add(new MenuPoint(controller, garageMenu, "remove sit from garage", new RemoveSitFromGarage()));
		}
		garageMenu.add(new MenuPoint(controller, mainMenu, "back"));
		// building master menu
		masterMenu.add(new MenuPoint(controller, masterMenu, "show all masters", new ShowAllMasters()));
		masterMenu
				.add(new MenuPoint(controller, masterMenu, "show all masters with sort", new ShowAllMastersWithSort()));
		masterMenu.add(new MenuPoint(controller, masterMenu, "create master", new CreateMaster()));
		masterMenu.add(new MenuPoint(controller, masterMenu, "delete master", new DeleteMaster()));
		masterMenu.add(new MenuPoint(controller, masterMenu, "add order to master", new AddOrderToMaster()));
		masterMenu.add(new MenuPoint(controller, masterMenu, "remove order from master", new RemoveOrderFromMaster()));
		masterMenu.add(new MenuPoint(controller, masterMenu, "show free masters on date", new ShowFreeMastersOnDate()));
		masterMenu.add(new MenuPoint(controller, masterMenu, "show order, executing by concrete master",
				new ShowOrderExecutingByConcreteMaster()));
		masterMenu.add(new MenuPoint(controller, mainMenu, "back"));
		// building order menu
		orderMenu.add(new MenuPoint(controller, orderMenu, "show all orders", new ShowAllOrders()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "show all orders with sort", new ShowAllOrdersWithSort()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "create order", new CreateOrder()));
		if (AutoServiceConfig.getInstance().isDeleteOrderEnabled()) {
			orderMenu.add(new MenuPoint(controller, orderMenu, "delete order", new DeleteOrder()));
		}
		orderMenu.add(new MenuPoint(controller, orderMenu, "add master to order", new AddMasterToOrder()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "remove master from order", new RemoveMasterFromOrder()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "set order cancelled", new SetOrderCancelled()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "set order closed", new SetOrderClosed()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "show executing orders", new ShowExecutingOrdersWithSort()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "show masters, executing concrete order",
				new ShowMastersExecutingConcreteOrder()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "show nearest free date", new ShowNearestFreeDate()));
		orderMenu.add(new MenuPoint(controller, orderMenu, "show orders for period of time with sort",
				new ShowOrdersForPeriodOfTimeWithSort()));
		if (AutoServiceConfig.getInstance().isShiftOrderTimeEnabled()) {
			orderMenu.add(
					new MenuPoint(controller, orderMenu, "shift order execution time", new ShiftOrderExecutionTime()));
		}
		orderMenu.add(new MenuPoint(controller, mainMenu, "back"));
		// building sit menu
		sitMenu.add(new MenuPoint(controller, sitMenu, "show all sits", new ShowAllSits()));
		sitMenu.add(new MenuPoint(controller, sitMenu, "create sit", new CreateSit()));
		sitMenu.add(new MenuPoint(controller, sitMenu, "delete sit", new DeleteSit()));
		sitMenu.add(new MenuPoint(controller, sitMenu, "add order to sit", new AddOrderToSit()));
		sitMenu.add(new MenuPoint(controller, sitMenu, "remove order from sit", new RemoveOrderFromSit()));
		sitMenu.add(new MenuPoint(controller, sitMenu, "show free sits", new ShowFreeSits()));
		sitMenu.add(new MenuPoint(controller, sitMenu, "show free sits at date", new ShowFreeSitsAtDate()));
		sitMenu.add(new MenuPoint(controller, mainMenu, "back"));
		// building other menu
		otherMenu.add(new MenuPoint(controller, otherMenu, "clone order", new CloneOrder()));
		otherMenu.add(new MenuPoint(controller, mainMenu, "back"));
		return mainMenu;
	}

}
