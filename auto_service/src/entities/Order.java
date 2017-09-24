package entities;

import java.util.Date;

public class Order extends BaseEntity {
	private double price;
	private Date addedDate;
	private Date startWorkingOnDate;
	private Date endingDate;
	private boolean closed;
	private boolean cancelled;
	private Master[] masters;

	public Order(double price, Date endingDate) {
		this.endingDate = endingDate;
		this.price = price;
		setAddedDate(null);// here will be date on adding
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
}
