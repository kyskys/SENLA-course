package garage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;

public class AddSitToGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public AddSitToGarageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idGarage = Long.valueOf(request.getParameter("sit"));
			Long idSit = Long.valueOf(request.getParameter("garage"));
			controller.addSitToGarage(idGarage, idSit);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
