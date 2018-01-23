package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;

public class SetOrderCancelledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public SetOrderCancelledServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idOrder = Long.valueOf(request.getParameter("order"));
		Boolean cancelled = Boolean.valueOf(request.getParameter("value"));
		controller.setOrderCancelled(idOrder, cancelled);
	}
}
