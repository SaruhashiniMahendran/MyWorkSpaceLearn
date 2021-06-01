package com.learn.converter;

import java.util.ArrayList;
import java.util.List;

import com.learn.dto.StudentDto;
import com.learn.entity.Student;

public class StudentConverter {
	//StudentDto---->>> StudentEntity
	
		public static Student stuDtoToStuEntity(StudentDto studentDto) {
			Student student = new Student();
			if(studentDto != null) {

				student.setFirstName(studentDto.getFirstName());
				student.setLastName(studentDto.getLastName());
				student.setFullName(studentDto.getFirstName() +" "+ studentDto.getLastName());
				return student;
			}
			return null;
		}
		
		//StudentEntity -> StudentDto
		public static List<StudentDto> stuEntityToStuDto(List<Student> students) {
			if(students != null) {
				List<StudentDto> studentDtos= new ArrayList<>(); 
				for(Student student:students) {
					
					StudentDto studentDto = new StudentDto();
					
					studentDto.setFirstName(student.getFirstName());
					studentDto.setLastName(student.getLastName());
					studentDto.setFullName(student.getFullName());
					
					studentDtos.add(studentDto);
				}
				return studentDtos;
			}
			return null;
		}
}
