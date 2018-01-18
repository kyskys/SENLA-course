package master;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Master;

import dependency.DependencyManager;
import master.dto.MasterDto;
import static util.Mapper.getMapper;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public MasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idMaster = Long.valueOf(request.getParameter("id"));
			MasterDto master = new MasterDto(controller.getMaster(idMaster));
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			getMapper().writeValue(response.getOutputStream(), master);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MasterDto dto = getMapper().readValue(request.getInputStream(), MasterDto.class);
			Master master = new Master();
			master.setBusy(dto.getBusy());
			master.setName(dto.getName());
			master.setId(dto.getId());
			controller.addMasterToOrder(dto.getId(), dto.getOrder());
			controller.updateMaster(master);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MasterDto dto = getMapper().readValue(request.getInputStream(), MasterDto.class);
			Master master = new Master();
			master.setBusy(dto.getBusy());
			master.setName(dto.getName());
			master.setId(dto.getId());
			controller.addMaster(master);
			controller.addMasterToOrder(dto.getId(), dto.getOrder());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MasterDto dto = getMapper().readValue(request.getInputStream(), MasterDto.class);
			Master master = new Master();
			master.setId(dto.getId());
			controller.deleteMaster(master);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
