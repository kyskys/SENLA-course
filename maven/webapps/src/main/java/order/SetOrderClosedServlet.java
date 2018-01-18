package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;

public class SetOrderClosedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public SetOrderClosedServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idOrder = Long.valueOf(request.getParameter("order"));
			Boolean closed = Boolean.valueOf(request.getParameter("value"));
			controller.setOrderClosed(idOrder, closed);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
