package com.learn.dto;

import java.util.List;

import com.learn.entity.Student;

public class SubjectRespDto {

	private String subjectName;
	
	private List<Student> student;
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
}
