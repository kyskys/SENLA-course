package entities;

import java.util.Date;
import java.util.List;

public class Order extends BaseEntity {
	private double price;
	private Date addedDate;
	private Date startWorkingOnDate;
	private Date endingDate;
	private boolean closed;
	private boolean cancelled;
	private List<Master> masters;

	public Order(long id, double price, Date endingDate) {
		super(id);
		this.setEndingDate(endingDate);
		this.setPrice(price);
		setAddedDate(null);// here will be date on adding
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getStartWorkingOnDate() {
		return startWorkingOnDate;
	}

	public void setStartWorkingOnDate(Date startWorkingOnDate) {
		this.startWorkingOnDate = startWorkingOnDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public List<Master> getMasters() {
		return masters;
	}
	public boolean addMaster(Master master) {
		return masters.add(master);
	}
	public boolean removeMaster(Master master) {
		return masters.remove(master);
	}
}
