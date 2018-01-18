package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;

public class AddMasterToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public AddMasterToOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idMaster = Long.valueOf(request.getParameter("master"));
			Long idOrder = Long.valueOf(request.getParameter("order"));
			controller.addMasterToOrder(idMaster, idOrder);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
