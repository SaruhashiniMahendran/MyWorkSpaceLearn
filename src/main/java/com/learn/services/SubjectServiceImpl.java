package com.learn.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.SubjectDto;
import com.learn.dto.SubjectRespDto;
import com.learn.entity.Subject;
import com.learn.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public void addSubject(SubjectDto subjectDto) {
		Subject subject = modelmapper.map(subjectDto, Subject.class);
		System.out.println(subject.getStudent());
		subjectRepository.save(subject);
	}
	
	@Override
	public List<SubjectRespDto> viewSubject(){
		List<Subject> subjects = subjectRepository.findAll();
		return subjects.stream().map(this::convertToRespDtods).collect(Collectors.toList());
	}
	
	private SubjectRespDto convertToRespDtods(Subject subject) {
		SubjectRespDto subjectRespDto = modelmapper.map(subject, SubjectRespDto.class);
		return subjectRespDto;
	}
	
	@Override
	public void updateSubject(SubjectDto subjectDto) {
		Subject subjectUpdate = modelmapper.map(subjectDto, Subject.class);
//		System.out.println(subjectUpdate.getId());
		subjectRepository.save(subjectUpdate);
	}
	
	@Override
	public void deleteSubject(Long id) {
		subjectRepository.deleteById(id);
	}
	
}