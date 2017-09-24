package entities;

public abstract class BaseEntity {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
