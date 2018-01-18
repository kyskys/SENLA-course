package master.dto;

import com.senla.entities.Master;

public class MasterDto {
	private Long id;
	private Long order;
	private Boolean busy;
	private String name;

	public MasterDto() {
		
	}
	
	public MasterDto(Master master) {
		this.id = master.getId();
		this.order = master.getOrder()!=null?master.getOrder().getId():null;
		this.busy = master.isBusy();
		this.name = master.getName();
	}

	public Long getId() {
		return id;
	}

	public Long getOrder() {
		return order;
	}

	public Boolean getBusy() {
		return busy;
	}

	public String getName() {
		return name;
	}
}
