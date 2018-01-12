package master;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Master;

import dependency.DependencyManager;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public MasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Master> masters = controller.getMasters();
			List<String> columns = new ArrayList<String>();
			columns.add("ID");
			columns.add("Name");
			columns.add("Busy");
			columns.add("Order ID");
			List<List<String>> content = new ArrayList<List<String>>();
			for (Master master : masters) {
				List<String> temp = new ArrayList<String>();
				temp.add(master.getId().toString());
				temp.add(master.getName());
				temp.add(String.valueOf(master.isBusy()));
				temp.add(master.getOrder() != null ? master.getOrder().getId().toString() : "none");
				content.add(temp);
			}
			request.setAttribute("pageTitle", "Master Table");
			request.setAttribute("columns", columns);
			request.setAttribute("content", content);
			request.setAttribute("hasDeleteLink", true);
			request.setAttribute("hasEditLink", true);
			request.setAttribute("deleteLinkValue", "/webapps/deleteMaster");
			request.setAttribute("editLinkValue", "/webapps/editMaster");
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
