package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;

import com.example.demo.service.CourseService;

@RequestMapping("/course")
@RestController
@CrossOrigin
public class CourseController {

	 CourseService cs;
	 
	 @Autowired
	 public CourseController(CourseService cs) {
		 this.cs =cs;
	 }
	 @PostMapping("/post")
		public void addCourse(@RequestBody Course course ) {
			cs.addCourse(course);
		}
		
	 @PutMapping("/update/{id}")
	 public void updateCourse(@RequestBody Course course , @PathVariable Long id) {
		 	cs.updateCourse(course , id);
	 }
	 
	 @GetMapping("/get")
		public List<Course> getall(){
			return cs.getCourses();
		}
	
	 
	 @DeleteMapping("/delete/{id}")
	 public void deleteCourse(@PathVariable Long id) {
		 cs.deleteCourse(id);
	 }
}
