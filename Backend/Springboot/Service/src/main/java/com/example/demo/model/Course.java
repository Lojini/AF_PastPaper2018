package com.example.demo.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="courses")
public class Course {
	
	private String code;
	
	private String name;
	
	private int passMark;
	
	private String lectureInCharge;
	
	private Double courseFee;
	
	private List<ObjectId> subject;
	
	public Double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassMark() {
		return passMark;
	}

	public void setPassMark(int passMark) {
		this.passMark = passMark;
	}

	public String getLectureInCharge() {
		return lectureInCharge;
	}

	public void setLectureInCharge(String lectureInCharge) {
		this.lectureInCharge = lectureInCharge;
	}

	public List<ObjectId> getSubjects() {
		return subject;
	}

	public void setSubjects(List<ObjectId> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Course [code=" + code + ", name=" + name + ", courseFee="+courseFee+"]";
	}
	
	
}
