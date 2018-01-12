package sit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Sit;

import dependency.DependencyManager;

public class SitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public SitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Sit> sits = controller.getSits();
			List<String> columns = new ArrayList<String>();
			columns.add("ID");
			columns.add("Order ID");
			columns.add("Garage ID");
			List<List<String>> content = new ArrayList<List<String>>();
			for (Sit sit : sits) {
				List<String> temp = new ArrayList<String>();
				temp.add(sit.getId().toString());
				temp.add(sit.getOrder() != null ? sit.getOrder().getId().toString() : "none");
				temp.add(sit.getGarage() != null ? sit.getGarage().getId().toString() : "none");
				content.add(temp);
			}
			request.setAttribute("pageTitle", "Sit Table");
			request.setAttribute("columns", columns);
			request.setAttribute("content", content);
			request.setAttribute("hasDeleteLink", true);
			request.setAttribute("hasEditLink", true);
			request.setAttribute("deleteLinkValue", "/webapps/deleteSit");
			request.setAttribute("editLinkValue", "/webapps/editSit");
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
