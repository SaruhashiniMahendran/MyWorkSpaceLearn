package com.learn.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.CourseDto;
import com.learn.entity.Course;
import com.learn.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
//	@Override
//	public List<Course> viewCourse(){
//		return courseRepository.findAll();
//	}
	@Override
	public List<CourseDto> viewCourse() {
		List<Course> courses = courseRepository.findAll();
		return courses.stream().map(this::convertToDtods).collect(Collectors.toList());
	}
	
	private CourseDto convertToDtods(Course course) {
		CourseDto courseDto = modelmapper.map(course, CourseDto.class);
		return courseDto;
	}
	
	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
	@Override
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
}
