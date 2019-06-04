package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {
  
	@Autowired
	private CourseRepository courseRepository;
	
	public Course getById(String code) {
		return courseRepository.findByCode(code);
	}
	
	
	
}
