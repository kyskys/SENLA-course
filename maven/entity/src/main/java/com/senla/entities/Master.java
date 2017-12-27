package com.senla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auto_service_db.master")
public class Master implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "master_id", nullable = false, unique = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Column(name = "busy", nullable = false, unique = false)
	private boolean busy;

	@Column(name = "name", nullable = false, unique = false)
	private String name;

	public Master() {

	}

	public Master(String name) {
		this.setName(name);
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
