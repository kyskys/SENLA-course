package entities;

public abstract class BaseEntity {
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	abstract public String getAsString();

	@Override
	public boolean equals(Object obj) {
		BaseEntity bm = (BaseEntity) obj;
		if (id != null && bm != null && bm.getId() != null) {
			return id.equals(bm.getId());
		}
		return false;
	}
}
