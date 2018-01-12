package com.senla.entities;

import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements BaseEntity, Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", nullable = false, unique = true)
	private Long id;

	@Column(name = "price", nullable = false, unique = false)
	private Double price;

	@Column(name = "added_date", nullable = false, unique = false)
	private Date addedDate;

	@Column(name = "start_date", nullable = true, unique = false)
	private Date startWorkingOnDate;

	@Column(name = "ending_date", nullable = false, unique = false)
	private Date endingDate;

	@Column(name = "closed", nullable = false, unique = false)
	private boolean closed;

	@Column(name = "cancelled", nullable = false, unique = false)
	private boolean cancelled;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<Master> masters;

	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
	private Sit sit;

	public Order() {

	}

	public Order(Double price, Date endingDate, Date startWorkingOnDate) {
		this.setEndingDate(endingDate);
		this.setPrice(price);
		this.setStartWorkingOnDate(startWorkingOnDate);
		setAddedDate(Date.valueOf(LocalDate.now()));
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
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
	public Order clone() {
		Order clone = new Order(this.getPrice(), this.getEndingDate(), this.getStartWorkingOnDate());
		clone.addedDate = this.addedDate;
		clone.cancelled = this.cancelled;
		clone.closed = this.closed;
		clone.masters = new ArrayList<Master>();
		return clone;
	}

	public Sit getSit() {
		return sit;
	}

	public void setSit(Sit sit) {
		this.sit = sit;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
