package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Course;

public interface CourseRepo extends CrudRepository<Course,Long> {

}
