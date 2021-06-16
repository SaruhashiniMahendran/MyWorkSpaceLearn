package com.learn.services;

import java.util.List;

import com.learn.dto.StudentDto;
import com.learn.dto.StudentRespDto;
import com.learn.entity.Student;

public interface StudentService {
	public void addStudent(StudentDto studentDto);
	
//	public List<StudentDto> viewStudent();
	public List<StudentRespDto> viewStudent();
	
	public void deleteStudent(Long id);

	public void updateStudent(StudentDto studentDto);
	
	public List<Student> getByLastName(String lastname);
	
	public List<Student> getByFirstName(String firstname);
	
	public List<Student> getStudentsByCourse(Long courseId);
	
}
