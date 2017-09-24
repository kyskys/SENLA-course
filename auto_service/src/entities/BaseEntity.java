package entities;

public abstract class BaseEntity {
	protected String name;

	public BaseEntity(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
