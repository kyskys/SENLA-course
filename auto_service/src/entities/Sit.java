package entities;

public class Sit extends BaseEntity {
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
	public String getAsString() {
		return "id :" + id + "order id: " + order.getId() + "garage id:" + garage.getId();
	}
}
