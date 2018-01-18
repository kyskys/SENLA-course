package garage.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.senla.entities.Garage;

public class GarageDto {
	private Long id;
	private List<Long> sits;

	public GarageDto(Garage garage) {
		this.id = garage.getId();
		this.sits = garage.getSits().stream().map(sit -> sit.getId()).collect(Collectors.toList());
	}

	public GarageDto() {

	}

	public Long getId() {
		return id;
	}

	public List<Long> getSits() {
		return sits;
	}
}
