package sit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Sit;

import dependency.DependencyManager;
import dto.SitDto;
import util.Mapper;

public class SitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public SitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idSit = Long.valueOf(request.getParameter("id"));
			SitDto sit = new SitDto(controller.getSit(idSit));
					response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			Mapper.getMapper().writeValue(response.getOutputStream(), sit);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SitDto dto = Mapper.getMapper().readValue(request.getInputStream(), SitDto.class);
			Sit sit = new Sit();
			sit.setId(dto.getId());
			sit.setGarage(controller.getGarage(dto.getGarage()));
			sit.setOrder(controller.getOrder(dto.getOrder()));
			controller.updateSit(sit);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SitDto dto = Mapper.getMapper().readValue(request.getInputStream(), SitDto.class);
			Sit sit = new Sit();
			sit.setId(dto.getId());
			controller.addSit(sit);
			sit.setGarage(dto.getGarage()!=null?controller.getGarage(dto.getGarage()):null);
			sit.setOrder(dto.getOrder()!=null?controller.getOrder(dto.getOrder()):null);
			controller.updateSit(sit);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SitDto dto = Mapper.getMapper().readValue(request.getInputStream(), SitDto.class);
			Sit sit = new Sit();
			sit.setId(dto.getId());
			controller.deleteSit(sit);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
