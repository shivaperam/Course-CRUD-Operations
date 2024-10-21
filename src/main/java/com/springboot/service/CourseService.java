package com.springboot.service;

import java.util.List;

import com.springboot.entity.CourseDetails;

public interface CourseService {

	public String upsert(CourseDetails courseDetails);
	
	public CourseDetails getById(Integer id);
	
	public List<CourseDetails>  getAllCourses();
	
	public String deleteById(Integer id);
}
