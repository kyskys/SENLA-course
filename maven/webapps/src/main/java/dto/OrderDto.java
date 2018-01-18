package dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.senla.entities.Order;

public class OrderDto {
	private Long id;
	private Double price;
	private Date addedDate;
	private Date endingDate;
	private Date StartWorkingOnDate;
	private boolean closed;
	private boolean cancelled;
	private List<Long> masters;

	public OrderDto(Order order) {
		this.id = order.getId();
		this.price = order.getPrice();
		this.addedDate = order.getAddedDate();
		this.endingDate = order.getEndingDate();
		this.StartWorkingOnDate = order.getStartWorkingOnDate();
		this.cancelled = order.isCancelled();
		this.closed = order.isClosed();
		this.masters = order.getMasters().stream().map(master -> master.getId()).collect(Collectors.toList());
	}

	public OrderDto() {
		
	}

	public Long getId() {
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public Date getStartWorkingOnDate() {
		return StartWorkingOnDate;
	}

	public boolean isClosed() {
		return closed;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public List<Long> getMasters() {
		return masters;
	}

}
