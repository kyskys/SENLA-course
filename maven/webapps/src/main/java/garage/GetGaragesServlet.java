package garage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import garage.dto.GarageDto;
import static util.Mapper.getMapper;

public class GetGaragesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public GetGaragesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<GarageDto> garages = controller.getGarages().stream().map(GarageDto::new).collect(Collectors.toList());
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			getMapper().writeValue(response.getOutputStream(), garages);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
