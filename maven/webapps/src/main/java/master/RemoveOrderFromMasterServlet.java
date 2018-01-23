package master;

import static util.Mapper.getMapper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;

import dependency.DependencyManager;
import dto.MasterOrderChainDto;

public class RemoveOrderFromMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public RemoveOrderFromMasterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MasterOrderChainDto chain = getMapper().readValue(request.getInputStream(), MasterOrderChainDto.class);
		controller.removeOrderFromMaster(chain.getOrder());
	}
}
