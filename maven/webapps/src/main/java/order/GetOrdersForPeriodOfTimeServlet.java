package order;

import static util.Mapper.getMapper;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.OrderDto;

public class GetOrdersForPeriodOfTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public GetOrdersForPeriodOfTimeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Date before = Date.valueOf(request.getParameter("before"));
			Date after = Date.valueOf(request.getParameter("after"));
			String parameter = request.getParameter("parameter");
			List<OrderDto> orders = controller.getOrdersForPeriodOfTime(before, after, parameter).stream()
					.map(OrderDto::new).collect(Collectors.toList());
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			getMapper().writeValue(response.getOutputStream(), orders);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
