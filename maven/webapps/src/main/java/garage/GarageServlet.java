package garage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.controller.IController;
import com.senla.entities.Garage;

import dependency.DependencyManager;
import dto.GarageDto;

import static util.Mapper.getMapper;

public class GarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IController controller = DependencyManager.getInstance(IController.class);

	public GarageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long idGarage = Long.valueOf(request.getParameter("id"));
			GarageDto garage = new GarageDto(controller.getGarage(idGarage));
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			getMapper().writeValue(response.getOutputStream(), garage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			GarageDto dto = getMapper().readValue(request.getInputStream(), GarageDto.class);
			Garage garage = new Garage();
			garage.setId(dto.getId());
			for(Long idSit : dto.getSits()) {
				controller.addSitToGarage(dto.getId(), idSit);
			}
			controller.updateGarage(garage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			GarageDto dto = getMapper().readValue(request.getInputStream(), GarageDto.class);
			Garage garage = new Garage();
			garage.setId(dto.getId());
			controller.addGarage(garage);
			for(Long idSit : dto.getSits()) {
				controller.addSitToGarage(dto.getId(), idSit);
			}
			controller.updateGarage(garage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			GarageDto dto = getMapper().readValue(request.getInputStream(), GarageDto.class);
			Garage garage = new Garage();
			garage.setId(dto.getId());
			controller.deleteGarage(garage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
