package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	Student findByFirstName(String name);
}
