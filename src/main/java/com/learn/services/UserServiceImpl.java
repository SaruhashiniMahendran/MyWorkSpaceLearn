package com.learn.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.UserDto;
import com.learn.dto.UserRespDto;
import com.learn.entity.Student;
import com.learn.entity.User;
import com.learn.repositories.StudentRepository;
import com.learn.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	ModelMapper modelmapper;

	@Override
	public void addUser(UserDto userDto) {
		User user = modelmapper.map(userDto, User.class);
		userRepository.save(user);
	}
//	@Override
//	public List<User> viewUser(){
//		return userRepository.findAll();
//	}
	
	@Override
	public List<UserRespDto> viewUser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(this::convertToDtods).collect(Collectors.toList());
	}
	
	private UserRespDto convertToDtods(User user) {
		UserRespDto userRespDto = modelmapper.map(user, UserRespDto.class);
		return userRespDto;
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);;
	}
	
	@Override
	public void updateUser(UserDto userDto) {
		User user = modelmapper.map(userDto, User.class);
		userRepository.save(user);
	}
	
	@Override
	public User getUserBystudent(Long StudentId) {
		return userRepository.findByStudentId(StudentId);
	}
	
	@Override
	public Optional<Student> getStudent(Long StudentId) {
		System.out.println(StudentId);
		return studentRepository.findById(StudentId);
	}
	@Override
	public Optional<User> getUserStudent(Long userId){
		userRepository.findById(userId);
		System.out.println(userRepository.findById(userId));
		return userRepository.findById(userId);
	}
	
//	@Override
//	public List<Student> getStudentsByCourse(Long courseId){
//		List<Student> students = new ArrayList<>();
//		studentRepository.findByCourseId(courseId).forEach(students::add);
//		return students;
//	}
}
