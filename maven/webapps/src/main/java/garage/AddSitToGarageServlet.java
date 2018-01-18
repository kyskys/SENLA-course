package garage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.SitGarageChainDto;

import static util.Mapper.getMapper;

public class AddSitToGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public AddSitToGarageServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			SitGarageChainDto chain = getMapper().readValue(request.getInputStream(), SitGarageChainDto.class);
			controller.addSitToGarage(chain.getGarage(), chain.getSit());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
