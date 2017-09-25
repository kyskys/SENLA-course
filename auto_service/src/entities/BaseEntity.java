package entities;

public abstract class BaseEntity {
	protected Long id;

	public BaseEntity(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		BaseEntity bm = (BaseEntity) obj;
		if (id != null && bm != null && bm.getId() != null) {
			return id.equals(bm.getId());
		}
		return false;
	}
}
