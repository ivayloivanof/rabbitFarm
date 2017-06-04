package com.rabbit_farm.areas.rabbit.models.binding;

import com.rabbit_farm.areas.rabbit.enumerations.RabbitSex;

import java.util.Date;

public class RabbitCreateBindingModel {

	private String name;

	private Date birthDate;

	private RabbitSex sex;

	private Long motherId;

	private Long fatherId;

	public RabbitCreateBindingModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public RabbitSex getSex() {
		return sex;
	}

	public void setSex(RabbitSex sex) {
		this.sex = sex;
	}

	public Long getMotherId() {
		return motherId;
	}

	public void setMotherId(Long motherId) {
		this.motherId = motherId;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}
}
