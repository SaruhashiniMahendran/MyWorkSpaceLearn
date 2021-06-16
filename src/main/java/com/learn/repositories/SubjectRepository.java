package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}