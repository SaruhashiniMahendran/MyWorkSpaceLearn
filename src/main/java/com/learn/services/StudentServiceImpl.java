package com.learn.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.StudentDto;
import com.learn.dto.StudentRespDto;
import com.learn.entity.Student;
import com.learn.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public void addStudent(StudentDto studentDto) {
		Student student = modelmapper.map(studentDto, Student.class);
//		student.setCourse(courseService.getCourse(studentDto.getCourseId()));
		student.setFullName(studentDto.getFirstName()+ " "+ studentDto.getLastName());
		studentRepository.save(student);
	}
	
	@Override
	public List<StudentRespDto> viewStudent() {
		List<Student> students = studentRepository.findAll();
		return students.stream().map(this::convertToDtods).collect(Collectors.toList());
	}
	
	private StudentRespDto convertToDtods(Student student) {
		StudentRespDto studentRespDto = modelmapper.map(student, StudentRespDto.class);
		return studentRespDto;
	}
	
	@Override
	public void updateStudent(StudentDto studentDto) {
		Student st = modelmapper.map(studentDto, Student.class);
		st.setFullName(studentDto.getFirstName()+ " "+ studentDto.getLastName());
		studentRepository.save(st);
	}
	
	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	@Override
	public List<Student> getByLastName(String lastName) {
		return (List<Student>) studentRepository.findByLastName(lastName);
	}
	
	@Override
	public List<Student> getByFirstName(String firstName) {
//		studentRepository.findByFirstName(firstName);
		return (List<Student>) studentRepository.findByFirstName(firstName);		
	}
	
	@Override
	public List<Student> getStudentsByCourse(Long courseId){
		List<Student> students = new ArrayList<>();
		studentRepository.findByCourseId(courseId).forEach(students::add);
		return students;
	}
	
}
