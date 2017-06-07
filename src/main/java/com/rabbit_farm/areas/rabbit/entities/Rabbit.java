package com.rabbit_farm.areas.rabbit.entities;

import com.rabbit_farm.areas.rabbit.enumerations.RabbitSex;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "rabbits")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rabbit_type")
public abstract class Rabbit implements Serializable {

	private static final long serialVersionUID = -5387530843605959352L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "birth_date")
	private Date birthDate;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RabbitSex sex;

	@Column(name = "mother_id")
	private Long motherId;

	@Column(name = "father_id")
	private Long fatherId;

	public Rabbit() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return this.sex;
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
