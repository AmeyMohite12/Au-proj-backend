package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepo;
import com.example.demo.model.Course;

@Service
public class CourseService {
	private CourseRepo courserepo;
	
	@Autowired
	public CourseService(CourseRepo courserepo){
		this.courserepo = courserepo;
	}
	
	
	public List<Course> getCourses(){
		 return (List<Course>) courserepo.findAll();
	}
	
	public void addCourse(Course course) {
		courserepo.save(course);
	}
	
	public void updateCourse(Course course, Long id) {
		courserepo.findById(id).map( crs->{
			crs.setCreator(course.getCreator());
			crs.setDescription(course.getDescription());
			return courserepo.save(crs);
		})
		.orElseGet(()->{
			course.setCourseId(id);
			return courserepo.save(course);
		});
	}
	
	public void deleteCourse(Long id) {
		courserepo.deleteById(id);
	}
	
}
