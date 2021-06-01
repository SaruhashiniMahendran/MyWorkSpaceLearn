package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
