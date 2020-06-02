package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.TrainerCourse;

public interface TrainerCourseRepo extends CrudRepository<TrainerCourse,Long>{
	public List<TrainerCourse> findByCourseid(Long courseid);
	public List<TrainerCourse> findByTrainerid(Long trainerid);
}
