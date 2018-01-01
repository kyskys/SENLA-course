package com.senla.entities;

public interface BaseEntity {

	public Long getId();

	public void setId(Long id);

	public static String getIdAsString(BaseEntity entity) {
		return entity == null ? "-" : entity.getId().toString();
	}
}
