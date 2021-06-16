package com.learn.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.CourseDto;
import com.learn.dto.CourseRespDto;
import com.learn.entity.Course;
import com.learn.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public void addCourse(CourseDto courseDto) {
		Course course = modelmapper.map(courseDto, Course.class);
		courseRepository.save(course);
	}
	
	@Override
	public List<CourseRespDto> viewCourse() {
		List<Course> courses = courseRepository.findAll();
		return courses.stream().map(this::convertToDtods).collect(Collectors.toList());
	}
	
	private CourseRespDto convertToDtods(Course course) {
		CourseRespDto courseRespDto = modelmapper.map(course, CourseRespDto.class);
		return courseRespDto;
	}
	
	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
	@Override
	public void updateCourse(CourseDto courseDto) {
		Course course = modelmapper.map(courseDto, Course.class);
		courseRepository.save(course);
	}
//	@Override
//	public Course getCourse(Long id) {
//		return courseRepository.findById(id).get();
//	}
	
}
