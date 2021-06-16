package com.learn.services;

import java.util.List;

import com.learn.dto.SubjectDto;
import com.learn.dto.SubjectRespDto;

public interface SubjectService {
	public void addSubject(SubjectDto subjectDto);
	
	public List<SubjectRespDto> viewSubject();
	
	public void updateSubject(SubjectDto subjectDto);
	
	public void deleteSubject(Long id);
}
