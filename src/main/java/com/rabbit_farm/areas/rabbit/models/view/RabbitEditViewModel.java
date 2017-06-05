package com.rabbit_farm.areas.rabbit.models.view;

import com.rabbit_farm.areas.rabbit.enumerations.RabbitSex;
import com.rabbit_farm.areas.vaccionation.entities.Vaccination;

import java.util.Date;
import java.util.List;

public class RabbitEditViewModel {

	private String name;

	private Date birthDate;

	private RabbitSex sex;

	private RabbitEditViewModel mother;

	private RabbitEditViewModel father;

	private Double weight;

	private List<Vaccination> vaccinations;

	private int days;

	public RabbitEditViewModel() {
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
}
