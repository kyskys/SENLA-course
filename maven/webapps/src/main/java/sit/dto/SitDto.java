package sit.dto;

import com.senla.entities.Sit;

public class SitDto {
	private Long id;
	private Long garage;
	private Long order;

	public SitDto(Sit sit) {
		this.id = sit.getId();
		this.garage = sit.getGarage() != null ? sit.getGarage().getId() : null;
		this.order = sit.getOrder() != null ? sit.getOrder().getId() : null;
	}

	public SitDto() {

	}

	public Long getId() {
		return id;
	}

	public Long getGarage() {
		return garage;
	}

	public Long getOrder() {
		return order;
	}
}
