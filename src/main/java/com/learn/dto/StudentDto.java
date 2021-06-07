package com.learn.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentDto {
	private Long id;
	@NotNull(message="Not be in Null")
	@NotBlank(message="Not be in Blank")
	@NotEmpty(message="Not be in Empty")
	private String firstName;
	@NotNull(message="Not be in Null")
	@NotBlank(message="Not be in Blank")
	@NotEmpty(message="Not be in Empty")
	private String lastName;
//	@NotNull(message="Not be in Null")
//	@NotBlank(message="Not be in Blank")
//	@NotEmpty(message="Not be in Empty")
	private Long courseId;
	private String fullName;
	
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	

}
