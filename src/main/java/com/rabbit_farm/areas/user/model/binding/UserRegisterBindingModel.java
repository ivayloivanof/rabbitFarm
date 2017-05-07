package com.rabbit_farm.areas.user.model.binding;

import com.rabbit_farm.areas.user.annotation.ValidEmail;

import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

	private Long id;

	@Size(min = 3, max = 65, message = "Invalid first name!")
	private String firstName;

	@Size(min = 3, max = 65, message = "Invalid last name!")
	private String lastName;

	@ValidEmail
	@Size(max = 100, message = "Invalid email address!")
	private String email;

	@Size(min = 4, max = 15, message = "Invalid Password!")
	private String password;

	//TODO compare password and repeatPassword
	private String passwordRepeat;

	public UserRegisterBindingModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
}
