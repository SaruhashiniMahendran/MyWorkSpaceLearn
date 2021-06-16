package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.learn.dto.SubjectDto;
import com.learn.dto.SubjectRespDto;
import com.learn.services.SubjectService;


@RestController
@RequestMapping(value="api/v1/subject")
public class SubjectController {
	
		@Autowired
		private SubjectService subjectService;
		
		@PostMapping(value="/add")
		public ResponseEntity<Object>addSubject(@Valid @RequestBody SubjectDto subjectDto){
			subjectService.addSubject(subjectDto);
			return new ResponseEntity<Object>("successfully entered Subject",HttpStatus.CREATED);
		}
		
		@GetMapping(value="/view")
		public ResponseEntity<List<SubjectRespDto>>viewSubject(){
			return new ResponseEntity<List<SubjectRespDto>>(subjectService.viewSubject(),HttpStatus.OK);
		}
		
		@PutMapping(value="/update")
		public ResponseEntity<Object>updateSubject(@Valid @RequestBody SubjectDto subjectDto){
//			System.out.println(subjectDto.getId());
			subjectService.updateSubject(subjectDto);
			return new ResponseEntity<Object>("Successfully chaned Subject",HttpStatus.OK);
		}
		
		@DeleteMapping(value="/delete/{id}")
		public ResponseEntity<String> deleteSubject(@PathVariable Long id){
			subjectService.deleteSubject(id);
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
}
