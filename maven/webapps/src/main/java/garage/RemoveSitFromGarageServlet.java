package garage;

import static util.Mapper.getMapper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.SitGarageChainDto;

public class RemoveSitFromGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public RemoveSitFromGarageServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SitGarageChainDto chain = getMapper().readValue(request.getInputStream(), SitGarageChainDto.class);
		controller.removeSitFromGarage(chain.getSit(), chain.getGarage());
	}
}
