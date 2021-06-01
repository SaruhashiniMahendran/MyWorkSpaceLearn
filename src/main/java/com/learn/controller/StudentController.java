package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.StudentDto;
import com.learn.entity.Student;
import com.learn.services.StudentService;

@RestController
@RequestMapping(value="api/v1/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	ModelMapper modelmapper;
	
	@PostMapping(value="/add")
	public ResponseEntity<Object>addStudent(@Valid @RequestBody StudentDto studentDto){
		Student student = modelmapper.map(studentDto, Student.class);
		student.setFullName(studentDto.getFirstName()+ " "+ studentDto.getLastName());
//	System.out.println(studentDto.getFullName());
		studentService.addStudent(student);
		return new ResponseEntity<Object>("successfully entered Student",HttpStatus.CREATED);
	}
	
	@GetMapping(value="/view")
	public ResponseEntity<List<StudentDto>> viewStudents(){
		return new ResponseEntity<List<StudentDto>>(studentService.viewStudent(),HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Object> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable("id") Long id ){
//		Student s1 = StudentConverter.stuDtoToStuEntity(studentDto);
		Student st = modelmapper.map(studentDto, Student.class);
		st.setId(id);
		st.setFullName(studentDto.getFirstName()+ " "+ studentDto.getLastName());
		studentService.updateStudent(st);
		return new ResponseEntity<Object>("successfully updated student",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Successfully deteted student",HttpStatus.OK);
	}
	
	
	@GetMapping("/lastname/{name}")
	public ResponseEntity<?> getByLastName(@PathVariable String name){
		return new ResponseEntity<>(studentService.getByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/firstname/{name}")
	public ResponseEntity<?> getByFirstName(@PathVariable String name){
		return new ResponseEntity<>(studentService.getByFirstName(name), HttpStatus.OK);
	}
}
