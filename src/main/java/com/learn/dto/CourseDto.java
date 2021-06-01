package com.learn.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CourseDto {
	private Long id;
	@NotNull(message="Not be in Null")
	@NotBlank(message="Not be in Blank")
	@NotEmpty(message="Not be in Empty")
	private String courseName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
