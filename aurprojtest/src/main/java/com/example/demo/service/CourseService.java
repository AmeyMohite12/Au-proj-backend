package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepo;
import com.example.demo.dao.TrainerCourseRepo;
import com.example.demo.model.Course;
import com.example.demo.model.TrainerCourse;

@Service
public class CourseService {
	private CourseRepo courserepo;
	
	@Autowired
	private TrainerCourseRepo trainercourserepo;
	
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
			crs.setPrerequisite(course.getPrerequisite());
			crs.setSkill(course.getSkill());
			crs.setlastupdated(course.getlastupdated());
			
			return courserepo.save(crs);
		})
		.orElseGet(()->{
			course.setCourseId(id);
			return courserepo.save(course);
		});
	}
	
	public void deleteCourse(Long id) {
		courserepo.deleteById(id);
		/// remove all entries from trainer course
		List<TrainerCourse> temp = trainercourserepo.findByCourseid(id);
		
		for(TrainerCourse t1 : temp) {
			trainercourserepo.deleteById(t1.getId());
		}
		
		
	}
	
}
