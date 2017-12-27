package com.senla.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Sit implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sit_id", nullable = false, unique = true)
	private Long id;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne(optional = false)
	@JoinColumn(name = "garage_id")
	private Garage garage;

	public Sit() {

	}

	public Sit(Garage garage) {
		this.garage = garage;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
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
