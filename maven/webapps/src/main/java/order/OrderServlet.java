package order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Order;

import dependency.DependencyManager;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public OrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Order> orders = controller.getOrders();
			List<String> columns = new ArrayList<String>();
			columns.add("ID");
			columns.add("Price");
			columns.add("Added date");
			columns.add("Start date");
			columns.add("Ending date");
			columns.add("Closed");
			columns.add("Cancelled");
			List<List<String>> content = new ArrayList<List<String>>();
			for (Order order : orders) {
				List<String> temp = new ArrayList<String>();
				temp.add(order.getId().toString());
				temp.add(order.getPrice() != null ? order.getPrice().toString() : "none");
				temp.add(order.getAddedDate().toString());
				temp.add(order.getStartWorkingOnDate().toString());
				temp.add(order.getEndingDate().toString());
				temp.add(String.valueOf(order.isClosed()));
				temp.add(String.valueOf(order.isCancelled()));
				content.add(temp);
			}
			request.setAttribute("pageTitle", "Order Table");
			request.setAttribute("columns", columns);
			request.setAttribute("content", content);
			request.setAttribute("hasDeleteLink", true);
			request.setAttribute("hasEditLink", true);
			request.setAttribute("deleteLinkValue", "/webapps/deleteOrder");
			request.setAttribute("editLinkValue", "/webapps/editOrder");
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
