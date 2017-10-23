package com.senla.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.senla.util.IdSequence;

public class Order extends BaseEntity implements Cloneable {

	private static final long serialVersionUID = 7123406903306647153L;
	private double price;
	private Date addedDate;
	private Date startWorkingOnDate;
	private Date endingDate;
	private boolean closed;
	private boolean cancelled;
	private List<Master> masters;

	public Order(double price, Date endingDate, Date startWorkingOnDate) {
		this.setEndingDate(endingDate);
		this.setPrice(price);
		this.setStartWorkingOnDate(startWorkingOnDate);
		setAddedDate(new Date());
		masters = new ArrayList<Master>();
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

	public void setMasters(List<Master> masters) {
		this.masters = masters;
	}

	public boolean addMaster(Master master) {
		return masters.add(master);
	}

	public boolean removeMaster(Master master) {
		return masters.remove(master);
	}
	
	@Override
	public String toString() {
		return String.format(
				"id: %s, price: %s, added: %s, start: %s, ending: %s, closed: %s, cancelled: %s, master: %s", id, price,
				addedDate, startWorkingOnDate, endingDate, closed, cancelled, masters);
	}

	@Override
	public Order clone() {
		Order clone = new Order(this.getPrice(), this.getEndingDate(), this.getStartWorkingOnDate());
		clone.addedDate = this.addedDate;
		clone.cancelled = this.cancelled;
		clone.closed = this.closed;
		clone.masters = new ArrayList<Master>();
		clone.id = IdSequence.getId();
		// Order clone = (Order) super.clone();
		// clone.setMasters(new ArrayList<Master>(clone.getMasters()));
		return clone;
	}
}
