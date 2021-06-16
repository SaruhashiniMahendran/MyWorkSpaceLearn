package com.learn.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByFirstName(String name);
	
	List<Student> findByLastName(String name);
	
	List<Student> findByCourseId(Long courseId);
	
	Optional<Student> findById(Long Id);
}
