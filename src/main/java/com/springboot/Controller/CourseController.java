package com.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.CourseDetails;
import com.springboot.service.CourseService;

@RestController
@RequestMapping("/coursedetails")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<String> createCourse(@RequestBody CourseDetails courseDetails){
		String status=courseService.upsert(courseDetails);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<CourseDetails> getById(@PathVariable Integer id){
		CourseDetails courseDetails=courseService.getById(id);
		return new ResponseEntity<CourseDetails>(courseDetails,HttpStatus.OK);
	}
	@GetMapping("/allcourses")
	public ResponseEntity<List<CourseDetails>> getAllCourses(){
		List<CourseDetails> allCourses=courseService.getAllCourses();
		return new ResponseEntity<>(allCourses,HttpStatus.OK);
	}
	
	@PutMapping("/updatecourse")
	public ResponseEntity<String> updateCourse(@RequestBody CourseDetails courseDetails){
		String status=courseService.upsert(courseDetails);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		String status=courseService.deleteById(id);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
}
