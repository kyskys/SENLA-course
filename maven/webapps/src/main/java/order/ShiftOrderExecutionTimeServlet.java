package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;

public class ShiftOrderExecutionTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public ShiftOrderExecutionTimeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int days = Integer.valueOf(request.getParameter("days"));
			controller.shiftOrdersTimeExecution(days);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
