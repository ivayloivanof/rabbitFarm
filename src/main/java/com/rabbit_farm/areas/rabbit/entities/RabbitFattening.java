package com.rabbit_farm.areas.rabbit.entities;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "rabbit_fattening")
public class RabbitFattening extends  Rabbit {

	@Basic
	private Double weight;

	@Basic
	private int days;

	public RabbitFattening() {
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public int getDays() {
		return this.days;
	}

	public void setDays(int days) {
		this.days = days;
	}
}
