package com.learn.controller;

import java.util.List;

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

import com.learn.dto.CourseDto;
import com.learn.entity.Course;
import com.learn.services.CourseService;

@RestController
@RequestMapping(value= "api/v1/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	ModelMapper modelmapper;
	
	@PostMapping(value="/add")
	public ResponseEntity<String>addCourse(@RequestBody CourseDto courseDto){
		Course course = modelmapper.map(courseDto, Course.class);
		courseService.addCourse(course);
		return new ResponseEntity<String>("Success fully entered course",HttpStatus.CREATED);
	}	
	
	@GetMapping("/view")
	public ResponseEntity<List<CourseDto>>courseView(){
		return new ResponseEntity<List<CourseDto>>(courseService.viewCourse(),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id){
//		System.out.println(id);
		courseService.deleteCourse(id);
		return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<Object>updateCourse(@RequestBody CourseDto courseDto){
		Course course = modelmapper.map(courseDto, Course.class);
		courseService.updateCourse(course);
		return new ResponseEntity<Object>("Successfully update course",HttpStatus.OK);
	}
}