package com.example.demo.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Double getAmountById(ObjectId id) {
		Subject subject= subjectRepository.findBy_id(id);
		return subject.getAmount();
		
	}
	
}
