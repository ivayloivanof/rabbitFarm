package com.rabbit_farm.areas.rabbit.entities;

import com.rabbit_farm.areas.vaccionation.entities.Vaccination;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "rabbit_breeding")
public class RabbitBreeding extends  Rabbit{

	private static final long serialVersionUID = 7329334044318739734L;

	@Basic
	private Double weight;

	@OneToMany
	private List<Vaccination> vaccinations;

	public RabbitBreeding() {
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public List<Vaccination> getVaccinations() {
		return this.vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}
}
