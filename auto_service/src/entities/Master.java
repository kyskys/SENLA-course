package entities;

public class Master extends BaseEntity {
	private Order order;
	private boolean busy;

	public Master(String name) {
		super(name);
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
		if (!order.equals(null)) {
			busy = true;
		}
	}
}
