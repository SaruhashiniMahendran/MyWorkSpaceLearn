package com.learn.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.learn.dto.StudentDto;
import com.learn.entity.Student;
import com.learn.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
//	@Autowired
//	private CourseService courseService;

	@Override
	public void addStudent(StudentDto studentDto) {
		Student student = modelmapper.map(studentDto, Student.class);
//		student.setCourse(courseService.getCourse(studentDto.getCourseId()));
		student.setFullName(studentDto.getFirstName()+ " "+ studentDto.getLastName());
		studentRepository.save(student);
	}
	
	@Override
	public List<StudentDto> viewStudent() {
		List<Student> students = studentRepository.findAll();
		return students.stream().map(this::convertToDtods).collect(Collectors.toList());
	}
	
	private StudentDto convertToDtods(Student student) {
		StudentDto studentDto = modelmapper.map(student, StudentDto.class);
		return studentDto;
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}
	
	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getByName(String name) {
		studentRepository.findByFirstName(name);
		return studentRepository.findAll();		
	}
	
	@Override
	public Student getByFirstName(String firstName) {
		studentRepository.findByFirstName(firstName);
		return (Student) studentRepository.findByFirstName(firstName);
				
	}
	@Override
	public List<Student>getStudentsByCourse(Long courseId){
		List<Student> students = new ArrayList<>();
		studentRepository.findByCourse(courseId).forEach(students::add);
		return students;
	}
	
}
