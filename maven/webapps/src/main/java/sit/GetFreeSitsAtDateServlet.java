package sit;

import static util.Mapper.getMapper;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.SitDto;

public class GetFreeSitsAtDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public GetFreeSitsAtDateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = Date.valueOf(request.getParameter("date"));
		List<SitDto> sits = controller.getFreeSitsAtDate(date).stream().map(SitDto::new).collect(Collectors.toList());
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		getMapper().writeValue(response.getOutputStream(), sits);
	}
}
