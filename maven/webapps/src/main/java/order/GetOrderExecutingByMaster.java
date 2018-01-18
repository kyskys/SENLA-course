package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.OrderDto;

import static util.Mapper.getMapper;

public class GetOrderExecutingByMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public GetOrderExecutingByMaster() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idMaster = Long.valueOf(request.getParameter("id"));
			OrderDto order = new OrderDto(controller.getOrderExecutingByConcreteMaster(idMaster));
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			getMapper().writeValue(response.getOutputStream(), order);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
