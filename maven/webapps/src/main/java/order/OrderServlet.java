package order;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Order;

import dependency.DependencyManager;
import dto.OrderDto;
import util.Mapper;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public OrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<OrderDto> orders = controller.getOrders().stream().map(OrderDto::new).collect(Collectors.toList());
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			Mapper.getMapper().writeValue(response.getOutputStream(), orders);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			OrderDto dto = Mapper.getMapper().readValue(request.getInputStream(), OrderDto.class);
			Order order = new Order();
			order.setId(dto.getId());
			order.setPrice(dto.getPrice());
			order.setAddedDate(dto.getAddedDate());
			order.setEndingDate(dto.getEndingDate());
			order.setStartWorkingOnDate(dto.getStartWorkingOnDate());
			order.setCancelled(dto.isCancelled());
			order.setClosed(dto.isClosed());
			for(Long idMaster : dto.getMasters()) {
				controller.addMasterToOrder(idMaster, dto.getId());
			}
			controller.updateOrder(order);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			OrderDto dto = Mapper.getMapper().readValue(request.getInputStream(), OrderDto.class);
			Order order = new Order();
			order.setId(dto.getId());
			order.setPrice(dto.getPrice());
			order.setAddedDate(dto.getAddedDate());
			order.setEndingDate(dto.getEndingDate());
			order.setStartWorkingOnDate(dto.getStartWorkingOnDate());
			order.setCancelled(dto.isCancelled());
			order.setClosed(dto.isClosed());
			controller.addOrder(order);
			for(Long idMaster : dto.getMasters()) {
				controller.addMasterToOrder(idMaster, dto.getId());
			}
			controller.updateOrder(order);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			OrderDto dto = Mapper.getMapper().readValue(request.getInputStream(), OrderDto.class);
			Order order = new Order();
			order.setId(dto.getId());
			controller.deleteOrder(order);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
