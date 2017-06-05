package com.rabbit_farm.areas.rabbit.models.binding;

import com.rabbit_farm.areas.rabbit.enumerations.RabbitSex;
import com.rabbit_farm.areas.rabbit.models.view.RabbitEditViewModel;

import java.util.Date;

public class RabbitEditBindingModel {

	private String name;

	private Date birthDate;

	private RabbitSex sex;

	private RabbitEditViewModel mother;

	private RabbitEditViewModel father;

	public RabbitEditBindingModel() {
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

	public RabbitEditViewModel getMother() {
		return mother;
	}

	public void setMother(RabbitEditViewModel mother) {
		this.mother = mother;
	}

	public RabbitEditViewModel getFather() {
		return father;
	}

	public void setFather(RabbitEditViewModel father) {
		this.father = father;
	}
}
