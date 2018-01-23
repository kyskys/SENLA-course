package sit;

import static util.Mapper.getMapper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.OrderSitChainDto;

public class AddOrderToSitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public AddOrderToSitServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderSitChainDto chain = getMapper().readValue(request.getInputStream(), OrderSitChainDto.class);
		controller.addOrderToSit(chain.getOrder(), chain.getSit());
	}
}
