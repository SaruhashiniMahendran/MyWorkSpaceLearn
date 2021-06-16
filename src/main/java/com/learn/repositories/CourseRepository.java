package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
