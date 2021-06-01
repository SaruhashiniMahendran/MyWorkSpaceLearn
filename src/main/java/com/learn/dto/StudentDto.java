package com.learn.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentDto {
	@NotNull(message="Not be in Null")
	@NotBlank(message="Not be in Blank")
	@NotEmpty(message="Not be in Empty")
	private String firstName;
	@NotNull(message="Not be in Null")
	@NotBlank(message="Not be in Blank")
	@NotEmpty(message="Not be in Empty")
	private String lastName;
	private String fullName;

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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
