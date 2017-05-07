package com.rabbit_farm.areas.vaccionation.entities;

import javax.persistence.*;

@Entity
@Table(name = "vaccinations")
public class Vaccination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Vaccination() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
