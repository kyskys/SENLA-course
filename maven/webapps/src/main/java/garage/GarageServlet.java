package garage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Garage;

import dependency.DependencyManager;

public class GarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public GarageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Garage> garages = controller.getGarages();
			List<String> columns = new ArrayList<String>();
			columns.add("ID");
			List<List<String>> content = new ArrayList<List<String>>();
			for (Garage garage : garages) {
				List<String> temp = new ArrayList<String>();
				temp.add(garage.getId().toString());
				content.add(temp);
			}
			request.setAttribute("pageTitle", "Garage Table");
			request.setAttribute("columns", columns);
			request.setAttribute("content", content);
			request.setAttribute("hasDeleteLink", true);
			request.setAttribute("hasEditLink", true);
			request.setAttribute("deleteLinkValue", "/webapps/deleteGarage");
			request.setAttribute("editLinkValue", "/webapps/editGarage");
			request.getRequestDispatcher("TablePageTemplate.jsp").forward(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
