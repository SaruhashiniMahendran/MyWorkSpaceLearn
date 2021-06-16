package com.learn.services;

import java.util.List;
import java.util.Optional;

import com.learn.dto.UserDto;
import com.learn.dto.UserRespDto;
import com.learn.entity.Student;
import com.learn.entity.User;

public interface UserService {
	public void addUser(UserDto userDto);
	
	public List<UserRespDto> viewUser();
	
	public void deleteUser(Long id);
	
	public void updateUser(UserDto userDto);
	
	public User getUserBystudent(Long StudentId);
	
	public Optional<Student> getStudent(Long StudentId);
	
	public Optional<User> getUserStudent(Long Id);
	
}
