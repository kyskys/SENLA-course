package sit;

import static util.Mapper.getMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.SitDto;

public class GetFreeSitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public GetFreeSitsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SitDto> sits = controller.getFreeSits().stream().map(SitDto::new).collect(Collectors.toList());
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		getMapper().writeValue(response.getOutputStream(), sits);
	}
}
