package com.learn.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.SubjectDto;
import com.learn.entity.Subject;
import com.learn.services.SubjectService;


@RestController
@RequestMapping(value="api/v1/subject")
public class SubjectController {
	
		@Autowired
		private SubjectService subjectService;
		
		@Autowired
		ModelMapper modelmapper;
		
		@PostMapping(value="/add")
		public ResponseEntity<Object>addSubject(@Valid @RequestBody SubjectDto subjectDto){
			Subject subject = modelmapper.map(subjectDto, Subject.class);
//		System.out.println(studentDto.getFullName());
			subjectService.addSubject(subject);
			return new ResponseEntity<Object>("successfully entered Subject",HttpStatus.CREATED);
		}
}
