package controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.controller.IController;
import com.senla.entities.Garage;
import com.senla.entities.Master;
import com.senla.entities.Order;
import com.senla.entities.Sit;
import com.senla.entities.User;
import com.senla.util.AuthCodeEnum;

import dto.AuthMessageDto;
import dto.GarageDto;
import dto.MasterDto;
import dto.OrderDto;
import dto.SitDto;
import dto.UserCredsDto;
import dto.UserDetailsDto;
import jwt.JWTManager;

@RestController
public class RESTController {

	@Autowired
	private IController controller;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public AuthMessageDto checkUser(@RequestBody UserCredsDto user) {
		AuthCodeEnum code = controller.checkUser(user.getLogin(), user.getPassword());
		if (code == AuthCodeEnum.SUCCESS_AUTH) {
			return new AuthMessageDto(AuthCodeEnum.SUCCESS_AUTH, JWTManager.createToken(controller.getUserByLogin(user.getLogin())));
		} else {
			return new AuthMessageDto(code);
		}
	}

	@RequestMapping(value = "/api/profile", method = RequestMethod.GET, produces = "application/json")
	public UserDetailsDto getUserDetails(@RequestParam(value = "id") Long id) {
		User user = controller.getUser(id);
		return new UserDetailsDto(user);
	}

	// Garages Service

	@RequestMapping(value = "/api/garage/addSit", method = RequestMethod.GET)
	public void addSitToGarage(@RequestParam(value = "sit") Long idSit, @RequestParam(value = "garage") Long idGarage) {
		controller.addSitToGarage(idGarage, idSit);
	}

	@RequestMapping(value = "/api/garage/removeSit", method = RequestMethod.GET)
	public void removeSitFromGarage(@RequestParam(value = "sit") Long idSit,
			@RequestParam(value = "garage") Long idGarage) {
		controller.removeSitFromGarage(idGarage, idSit);
	}

	@RequestMapping(value = "/api/garage", method = RequestMethod.GET, produces = "application/json")
	public GarageDto getGarage(@RequestParam(value = "id") Long id) {
		GarageDto garage = new GarageDto(controller.getGarage(id));
		return garage;

	}

	@RequestMapping(value = "/api/garage", method = RequestMethod.PUT)
	public void createGarage(@RequestBody GarageDto dto) {
		Garage garage = new Garage();
		garage.setId(dto.getId());
		controller.addGarage(garage);
		for (Long idSit : dto.getSits()) {
			controller.addSitToGarage(dto.getId(), idSit);
		}
		controller.updateGarage(garage);
	}

	@RequestMapping(value = "/api/garage", method = RequestMethod.DELETE)
	public void deleteGarage(@RequestParam(value = "id") Long id) {
		Garage garage = controller.getGarage(id);
		controller.deleteGarage(garage);
	}

	@RequestMapping(value = "/api/garage", method = RequestMethod.POST)
	public void updateGarage(@RequestBody GarageDto dto) {
		Garage garage = new Garage();
		garage.setId(dto.getId());
		for (Long idSit : dto.getSits()) {
			controller.addSitToGarage(dto.getId(), idSit);
		}
		controller.updateGarage(garage);
	}

	@RequestMapping(value = "/api/garages", method = RequestMethod.GET, produces = "application/json")
	public List<GarageDto> getGarages() {
		List<GarageDto> garages = controller.getGarages().stream().map(GarageDto::new).collect(Collectors.toList());
		return garages;
	}

	// Masters Service

	@RequestMapping(value = "/api/master/addOrder", method = RequestMethod.GET)
	public void addOrderToMaster(@RequestParam(value = "order") Long idOrder,
			@RequestParam(value = "master") Long idMaster) {
		controller.addOrderToMaster(idOrder, idMaster);
	}

	@RequestMapping(value = "/api/master/removeOrder", method = RequestMethod.GET)
	public void removeOrderFromMaster(@RequestParam(value = "id") Long idMaster) {
		controller.removeOrderFromMaster(idMaster);
	}

	@RequestMapping(value = "/api/masters/free", method = RequestMethod.GET, produces = "application/json")
	public List<MasterDto> getFreeMastersOnDate(@RequestParam(value = "date") Date date) {
		List<MasterDto> masters = controller.getFreeMastersOnDate(date).stream().map(MasterDto::new)
				.collect(Collectors.toList());
		return masters;
	}

	@RequestMapping(value = "/api/masters/byOrder", method = RequestMethod.GET, produces = "application/json")
	public List<MasterDto> getMastersExecutingOrder(@RequestParam(value = "id") Long idOrder) {
		List<MasterDto> masters = controller.getMastersExecutingConcreteOrder(idOrder).stream().map(MasterDto::new)
				.collect(Collectors.toList());
		return masters;
	}

	@RequestMapping(value = "/api/master", method = RequestMethod.GET, produces = "application/json")
	public MasterDto getMaster(@RequestParam(value = "id") Long id) {
		MasterDto master = new MasterDto(controller.getMaster(id));
		return master;
	}

	@RequestMapping(value = "/api/master", method = RequestMethod.PUT)
	public void createMaster(@RequestBody MasterDto dto) {
		Master master = new Master();
		master.setBusy(dto.isBusy());
		master.setName(dto.getName());
		master.setId(dto.getId());
		controller.addMaster(master);
		controller.addMasterToOrder(dto.getId(), dto.getOrder());
	}

	@RequestMapping(value = "/api/master", method = RequestMethod.DELETE)
	public void deleteMaster(@RequestParam(value = "id") Long id) {
		Master master = controller.getMaster(id);
		controller.deleteMaster(master);
	}

	@RequestMapping(value = "/api/master", method = RequestMethod.POST)
	public void updateMaster(@RequestBody MasterDto dto) {
		Master master = new Master();
		master.setBusy(dto.isBusy());
		master.setName(dto.getName());
		master.setId(dto.getId());
		controller.addMasterToOrder(dto.getId(), dto.getOrder());
		controller.updateMaster(master);
	}

	@RequestMapping(value = "/api/masters", method = RequestMethod.GET, produces = "application/json")
	public List<MasterDto> getMasters(@RequestParam(value = "parameter", required = false) String parameter) {
		List<MasterDto> masters = controller.getMasters(parameter).stream().map(MasterDto::new)
				.collect(Collectors.toList());
		return masters;
	}

	// Orders Service

	@RequestMapping(value = "/api/order/addMaster", method = RequestMethod.GET)
	public void addMasterToOrder(@RequestParam(value = "master") Long idMaster,
			@RequestParam(value = "order") Long idOrder) {
		controller.addMasterToOrder(idMaster, idOrder);
	}

	@RequestMapping(value = "/api/order/removeMaster", method = RequestMethod.GET)
	public void removeMasterFromOrder(@RequestParam(value = "master") Long idMaster,
			@RequestParam(value = "order") Long idOrder) {
		controller.removeMasterFromOrder(idMaster, idOrder);
	}

	@RequestMapping(value = "/api/orders/executing", method = RequestMethod.GET, produces = "application/json")
	public List<OrderDto> getExecutingOrders(@RequestParam(value = "parameter", required = false) String parameter) {
		List<OrderDto> orders = controller.getExecutingOrders(parameter).stream().map(OrderDto::new)
				.collect(Collectors.toList());
		return orders;
	}

	@RequestMapping(value = "/api/order/nearest", method = RequestMethod.GET, produces = "application/json")
	public Date getNearestDate() {
		Date date = controller.getNearestFreeDate();
		return date;
	}

	@RequestMapping(value = "/api/order/byMaster", method = RequestMethod.GET, produces = "application/json")
	public OrderDto getOrderExecutingByMaster(@RequestParam(value = "id") Long idMaster) {
		OrderDto order = new OrderDto(controller.getOrderExecutingByConcreteMaster(idMaster));
		return order;
	}

	@RequestMapping(value = "/api/orders/period", method = RequestMethod.GET, produces = "application/json")
	public List<OrderDto> getOrdersForPeriodOfTime(@RequestParam(value = "before") Date before,
			@RequestParam(value = "before") Date after,
			@RequestParam(value = "parameter", required = false) String parameter) {
		List<OrderDto> orders = controller.getOrdersForPeriodOfTime(before, after, parameter).stream()
				.map(OrderDto::new).collect(Collectors.toList());
		return orders;
	}

	@RequestMapping(value = "/api/order/cancelled", method = RequestMethod.GET)
	public void setOrderCancelled(@RequestParam(value = "id") Long id, @RequestParam(value = "value") Boolean value) {
		controller.setOrderCancelled(id, value);
	}

	@RequestMapping(value = "/api/order/closed", method = RequestMethod.GET)
	public void setOrderClosed(@RequestParam(value = "id") Long id, @RequestParam(value = "value") Boolean value) {
		controller.setOrderClosed(id, value);
	}

	@RequestMapping(value = "/api/order/shift", method = RequestMethod.GET)
	public void shiftOrderExecutionTime(@RequestParam(value = "days") int days) {
		controller.shiftOrdersTimeExecution(days);
	}

	@RequestMapping(value = "/api/order", method = RequestMethod.GET, produces = "application/json")
	public OrderDto getOrder(@RequestParam(value = "id") Long id) {
		OrderDto order = new OrderDto(controller.getOrder(id));
		return order;
	}

	@RequestMapping(value = "/api/order", method = RequestMethod.PUT)
	public void createOrder(@RequestBody OrderDto dto) {
		Order order = new Order();
		order.setId(dto.getId());
		order.setPrice(dto.getPrice());
		order.setAddedDate(dto.getAddedDate());
		order.setEndingDate(dto.getEndingDate());
		order.setStartWorkingOnDate(dto.getStartWorkingOnDate());
		order.setCancelled(dto.isCancelled());
		order.setClosed(dto.isClosed());
		controller.addOrder(order);
		for (Long idMaster : dto.getMasters()) {
			controller.addMasterToOrder(idMaster, dto.getId());
		}
		controller.updateOrder(order);
	}

	@RequestMapping(value = "/api/order", method = RequestMethod.DELETE)
	public void deleteOrder(@RequestParam(value = "id") Long id) {
		Order order = controller.getOrder(id);
		controller.deleteOrder(order);
	}

	@RequestMapping(value = "/api/order", method = RequestMethod.POST)
	public void updateOrder(@RequestBody OrderDto dto) {
		Order order = new Order();
		order.setId(dto.getId());
		order.setPrice(dto.getPrice());
		order.setAddedDate(dto.getAddedDate());
		order.setEndingDate(dto.getEndingDate());
		order.setStartWorkingOnDate(dto.getStartWorkingOnDate());
		order.setCancelled(dto.isCancelled());
		order.setClosed(dto.isClosed());
		for (Long idMaster : dto.getMasters()) {
			controller.addMasterToOrder(idMaster, dto.getId());
		}
		controller.updateOrder(order);
	}

	@RequestMapping(value = "/api/orders", method = RequestMethod.GET, produces = "application/json")
	public List<OrderDto> getOrders(@RequestParam(value = "parameter", required = false) String parameter) {
		List<OrderDto> orders = controller.getOrders().stream().map(OrderDto::new).collect(Collectors.toList());
		return orders;
	}

	// Sits Service

	@RequestMapping(value = "/api/sit/addGarage", method = RequestMethod.GET)
	public void addGarageToSit(@RequestParam(value = "garage") Long idGarage, @RequestParam(value = "sit") Long idSit) {
		controller.addSitToGarage(idGarage, idSit);
	}

	@RequestMapping(value = "/api/sit/removeGarage", method = RequestMethod.GET)
	public void removeGarageFromSit(@RequestParam(value = "garage") Long idGarage,
			@RequestParam(value = "sit") Long idSit) {
		controller.removeSitFromGarage(idSit, idGarage);
	}

	@RequestMapping(value = "/api/sit/addOrder", method = RequestMethod.GET)
	public void addOrderToSit(@RequestParam(value = "garage") Long idOrder, @RequestParam(value = "sit") Long idSit) {
		controller.addOrderToSit(idOrder, idSit);
	}

	@RequestMapping(value = "/api/sit/removeOrder", method = RequestMethod.GET)
	public void removeOrderFromSit(@RequestParam(value = "sit") Long idSit) {
		controller.removeOrderFromSit(idSit);
	}

	@RequestMapping(value = "/api/sits/free", method = RequestMethod.GET, produces = "application/json")
	public List<SitDto> getFreeSits() {
		List<SitDto> sits = controller.getFreeSits().stream().map(SitDto::new).collect(Collectors.toList());
		return sits;
	}

	@RequestMapping(value = "/api/sits/freeOnDate", method = RequestMethod.GET, produces = "application/json")
	public List<SitDto> getFreeSitsOnDate(@RequestParam(value = "date") Date date) {
		List<SitDto> sits = controller.getFreeSitsAtDate(date).stream().map(SitDto::new).collect(Collectors.toList());
		return sits;
	}

	@RequestMapping(value = "/api/sit", method = RequestMethod.GET, produces = "application/json")
	public SitDto getSit(@RequestParam(value = "id") Long id) {
		SitDto Sit = new SitDto(controller.getSit(id));
		return Sit;
	}

	@RequestMapping(value = "/api/sit", method = RequestMethod.PUT)
	public void createSit(@RequestBody SitDto dto) {
		Sit sit = new Sit();
		sit.setId(dto.getId());
		controller.addSit(sit);
		sit.setGarage(dto.getGarage() != null ? controller.getGarage(dto.getGarage()) : null);
		sit.setOrder(dto.getOrder() != null ? controller.getOrder(dto.getOrder()) : null);
		controller.updateSit(sit);
	}

	@RequestMapping(value = "/api/sit", method = RequestMethod.DELETE)
	public void deleteSit(@RequestParam(value = "id") Long id) {
		Sit Sit = controller.getSit(id);
		controller.deleteSit(Sit);
	}

	@RequestMapping(value = "/api/sit", method = RequestMethod.POST)
	public void updateSit(@RequestBody SitDto dto) {
		Sit sit = new Sit();
		sit.setId(dto.getId());
		sit.setGarage(controller.getGarage(dto.getGarage()));
		sit.setOrder(controller.getOrder(dto.getOrder()));
		controller.updateSit(sit);
	}

	@RequestMapping(value = "/api/sits", method = RequestMethod.GET, produces = "application/json")
	public List<SitDto> getSits(@RequestParam(value = "parameter", required = false) String parameter) {
		List<SitDto> sits = controller.getSits().stream().map(SitDto::new).collect(Collectors.toList());
		return sits;
	}
}
