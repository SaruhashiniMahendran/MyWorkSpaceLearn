package com.learn.services;

import java.util.List;

import com.learn.dto.StudentDto;
import com.learn.entity.Student;

public interface StudentService {
	public void addStudent(Student student);
	
	public List<StudentDto> viewStudent();
	
	public void deleteStudent(Long id);

	public void updateStudent(Student student);
	
	public List<Student> getByName(String firstname);
	
	public Student getByFirstName(String firstname);
}
