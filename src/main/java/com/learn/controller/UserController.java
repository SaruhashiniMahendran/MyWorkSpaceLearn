package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.learn.dto.UserDto;
import com.learn.entity.User;
import com.learn.services.UserService;

@RestController
@RequestMapping(value="api/v1/user")

	public class UserController {
		
		@Autowired
		private UserService userService;
		
		@Autowired
		ModelMapper modelmapper;
		
		@PostMapping(value="/add")
		public ResponseEntity<Object>addUser(@Valid @RequestBody UserDto userDto){
			User user = modelmapper.map(userDto, User.class);
			userService.addUser(user);
//			userService.addUser(UserConverter.UserDtoToUserEntity(userDto));
			return new ResponseEntity<Object>("Successfully added user",HttpStatus.CREATED);
		}
		@GetMapping(value="/view")
		public ResponseEntity<List<UserDto>> viewUser(){
			return new ResponseEntity<List<UserDto>>(userService.viewUser(),HttpStatus.OK);
		}
		@DeleteMapping(value="/delete/{id}")
		public ResponseEntity<String> deleteUser(@PathVariable Long id){
			userService.deleteUser(id);
			return new ResponseEntity<String>("successfully delete user",HttpStatus.OK);
		}
		@PutMapping(value="/update/{id}")
		public ResponseEntity<Object>updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") Long id ){
			User user = modelmapper.map(userDto, User.class);
			user.setId(id);
			return new ResponseEntity<>("Successfully updated user",HttpStatus.OK);
		}

}
