package com.learn.services;

import java.util.List;

import com.learn.dto.CourseDto;
import com.learn.dto.CourseRespDto;
public interface CourseService {
	
	public void addCourse(CourseDto courseDto);
	
	public List<CourseRespDto> viewCourse();
	
	public void deleteCourse(Long id);
	
	public void updateCourse(CourseDto courseDto);
	
//	public Course getCourse(Long id);
}
