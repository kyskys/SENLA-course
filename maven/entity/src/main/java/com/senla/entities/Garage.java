package com.senla.entities;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Table(name = "garages")
public class Garage implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "garage_id", nullable = false, unique = true)
	private Long id;

	@OneToMany(mappedBy = "garage", fetch = FetchType.EAGER)
	private List<Sit> sits;

	public boolean addSit(Sit sit) {
		return sits.add(sit);
	}

	public boolean removeSit(Sit sit) {
		return sits.remove(sit);
	}

	public List<Sit> getSits() {
		return sits;
	}

	public void setSits(List<Sit> sits) {
		this.sits = sits;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
