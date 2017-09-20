package entity;

public abstract class AEntity {
	protected String name;
	
	public AEntity(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
