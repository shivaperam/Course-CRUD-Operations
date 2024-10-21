package com.springboot.serviceImpleentation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.entity.CourseDetails;
import com.springboot.repository.CourseRepository;
import com.springboot.service.CourseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

	private CourseRepository repo;
	@Override
	public String upsert(CourseDetails courseDetails) {
          repo.save(courseDetails);
		return "Record saved successfully";
	}

	@Override
	public CourseDetails getById(Integer id) {

		Optional<CourseDetails> findById=repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<CourseDetails> getAllCourses() {
		
		return repo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
	if(repo.existsById(id)) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
		return "Id does not exsists";
	}

}
