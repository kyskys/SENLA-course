package com.senla.entities;

public class Sit extends BaseEntity {

	private static final long serialVersionUID = -3928754055014593485L;
	private Order order;
	private Garage garage;

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
	public String toString() {
		return String.format("id: %s, order id: %s, garage id: %s", id, BaseEntity.getIdAsString(order),
				BaseEntity.getIdAsString(garage));
	}
}
