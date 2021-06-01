package com.learn.services;

import java.util.List;

import com.learn.dto.UserDto;
import com.learn.entity.User;

public interface UserService {
	public void addUser(User user);
	
	public List<UserDto> viewUser();
	
	public void deleteUser(Long id);
	
	public void updateUser(User user);
}
