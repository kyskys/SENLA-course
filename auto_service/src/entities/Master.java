package entities;

public class Master extends BaseEntity {
	private Order order;
	private boolean busy;
	private String name;

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
	public String toString() {
		return "id: " + id + " name: " + name + " busy: " + busy + " order id: " + BaseEntity.getIdAsString(order);
	}
}
