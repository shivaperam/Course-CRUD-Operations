package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.CourseDetails;

public interface CourseRepository extends JpaRepository<CourseDetails, Integer>{

}
