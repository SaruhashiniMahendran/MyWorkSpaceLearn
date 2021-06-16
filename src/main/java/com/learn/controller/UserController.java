package com.learn.controller;


import java.util.List;
import java.util.Optional;

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

import com.learn.dto.UserDto;
import com.learn.dto.UserRespDto;
import com.learn.entity.Student;
import com.learn.entity.User;
import com.learn.services.UserService;

@RestController
@RequestMapping(value="api/v1/user")

	public class UserController {
		
		@Autowired
		private UserService userService;
		
		@PostMapping(value="/add")
		public ResponseEntity<Object>addUser(@Valid @RequestBody UserDto userDto){
			userService.addUser(userDto);
//			userService.addUser(UserConverter.UserDtoToUserEntity(userDto));
			return new ResponseEntity<Object>("Successfully added user",HttpStatus.CREATED);
		}
		@GetMapping(value="/view")
		public ResponseEntity<List<UserRespDto>> viewUser(){
			return new ResponseEntity<List<UserRespDto>>(userService.viewUser(),HttpStatus.OK);
		}
		@DeleteMapping(value="/delete/{id}")
		public ResponseEntity<String> deleteUser(@PathVariable Long id){
			userService.deleteUser(id);
			return new ResponseEntity<String>("successfully delete user",HttpStatus.OK);
		}
		@PutMapping(value="/update")
		public ResponseEntity<Object>updateUser(@Valid @RequestBody UserDto userDto){
			userService.updateUser(userDto);
			return new ResponseEntity<>("Successfully updated user",HttpStatus.OK);
		}
		@GetMapping("/user/{studentId}")
		public User getAllStudents(@PathVariable Long studentId){
			return userService.getUserBystudent(studentId);
		}
		
		@GetMapping("/student/{studentId}")
		public Optional<Student> getStudent(@PathVariable Long studentId){
			return userService.getStudent(studentId);
		}
		
		@GetMapping("/userstu/{userId}")
		public Optional<User> getUserStudent(@PathVariable Long userId){
			return userService.getUserStudent(userId);
		}
}
