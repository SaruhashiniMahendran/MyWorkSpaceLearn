package com.learn.converter;

import java.util.ArrayList;
import java.util.List;

import com.learn.dto.CourseDto;
import com.learn.entity.Course;

public class CourseConverter {
	//CourseDto -> CourseEntity
	
		public static Course couDtoToCouEntity(CourseDto courseDto) {
			Course course = new Course();
			if(courseDto != null) {		
				course.setId(courseDto.getId());
				course.setCourseName(courseDto.getCourseName());
				return course;
			}
			return null;
		}
			
		//CourseEntity -> CourseDto
		public static List<CourseDto> couEntityToCouDto(List<Course> courses) {
			if(courses != null) {
				List<CourseDto> courseDtos = new ArrayList<>();
				for(Course course:courses) {
					
					CourseDto courseDto = new CourseDto();
					
					courseDto.setId(course.getId());
					courseDto.setCourseName(course.getCourseName());
					
					courseDtos.add(courseDto);
				}
				return courseDtos;
			}
			return null;
			
		}
}
