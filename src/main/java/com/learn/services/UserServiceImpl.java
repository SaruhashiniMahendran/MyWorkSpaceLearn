package com.learn.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.UserDto;
import com.learn.entity.User;
import com.learn.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ModelMapper modelmapper;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}
//	@Override
//	public List<User> viewUser(){
//		return userRepository.findAll();
//	}
	
	@Override
	public List<UserDto> viewUser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(this::convertToDtods).collect(Collectors.toList());
	}
	
	private UserDto convertToDtods(User user) {
		UserDto userDto = modelmapper.map(user, UserDto.class);
		return userDto;
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);;
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
}
