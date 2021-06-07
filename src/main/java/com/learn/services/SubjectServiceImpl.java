package com.learn.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entity.Subject;
import com.learn.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public void addSubject(Subject subject) {
		subjectRepository.save(subject);
	}
}