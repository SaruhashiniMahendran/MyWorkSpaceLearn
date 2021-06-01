package com.learn.services;

import java.util.List;

import com.learn.dto.CourseDto;
import com.learn.entity.Course;

public interface CourseService {
	
	public void addCourse(Course course);
	
	public List<CourseDto> viewCourse();
	
	public void deleteCourse(Long id);
	
	public void updateCourse(Course course);
}
