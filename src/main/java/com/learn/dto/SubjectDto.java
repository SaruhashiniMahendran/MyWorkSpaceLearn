package com.learn.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.learn.entity.Student;

public class SubjectDto {
	private Long id;
	@NotNull(message="Not be in Null")
	@NotBlank(message="Not be in Blank")
	@NotEmpty(message="Not be in Empty")
	private String subjectName;
	
	private List<Student> studentId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public List<Student> getStudentId() {
		return studentId;
	}
	public void setStudentId(List<Student> studentId) {
		this.studentId = studentId;
	}
	
	
}
