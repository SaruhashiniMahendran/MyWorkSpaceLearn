package com.learn.converter;

import java.util.ArrayList;
import java.util.List;

import com.learn.dto.UserDto;
import com.learn.entity.User;

public class UserConverter {
	//UserDto ->UserEntity
		public static User UserDtoToUserEntity(UserDto userDto) {
			User user = new User();
			if(userDto != null) {
				user.setId(userDto.getId());
				user.setEmail(userDto.getEmail());
				user.setPassword(userDto.getPassword());
			}
			return user;
		}
		//UserEntity ->UserDto
		public static List<UserDto> userEntityToUserDto(List<User> users){
			if(users != null) {
				List<UserDto> userDtos = new ArrayList<>();
				for(User user:users) {
					UserDto userDto = new UserDto();
					
					userDto.setId(user.getId());
					userDto.setEmail(user.getEmail());
					userDto.setPassword(user.getPassword());
					
					userDtos.add(userDto);	
				}
				return userDtos;
			}
			return null;
		}
}
