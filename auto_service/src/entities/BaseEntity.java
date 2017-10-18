package entities;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -2889907438278728120L;
	protected Long id;

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

	public static String getIdAsString(BaseEntity entity) {
		return entity == null ? "-" : entity.getId().toString();
	}
}
