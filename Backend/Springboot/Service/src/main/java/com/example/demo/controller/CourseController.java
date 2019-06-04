package com.example.demo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import com.example.demo.service.SubjectService;

@RestController
@RequestMapping(value="/fees")
public class CourseController {
      
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SubjectService subjectService;
	
	Double TotalCourseFee= 0.0;
	 
	@RequestMapping(value="/{code}",  method=RequestMethod.GET)
	public HttpEntity<Course> calculateCourseFee(@PathVariable("code") String code){
		Course course = courseService.getById(code);
		List<ObjectId> subjects =course.getSubjects();
		for(int i=0;i<subjects.size();i++) {
			 TotalCourseFee+=subjectService.getAmountById(subjects.get(i));
		}  
		course.setCourseFee(TotalCourseFee);
		return new ResponseEntity<Course>(course,HttpStatus.OK);
		
	}
}
