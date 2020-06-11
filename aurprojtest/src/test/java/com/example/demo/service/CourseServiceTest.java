package com.example.demo.service;

import static org.junit.Assert.*;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import com.example.demo.dao.CourseRepo;
import com.example.demo.dao.TrainerCourseRepo;
import com.example.demo.model.Course;
import com.example.demo.model.TrainerCourse;


public class CourseServiceTest {

	@Mock
	CourseRepo courserepo;
	
	@Mock
	TrainerCourseRepo trainercourserepo;
	
	@InjectMocks
	CourseService courseservice;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
        Date d = new Date();
		Course course = new Course((long)1, "hello" ,"how" ,"are" , "you" , d);
		when(courserepo.save(course)).thenReturn(course);        
	}
	
	@Test
	public void addCourse() {
        Date d = new Date();

		Course course = new Course((long)1, "hello" ,"how" ,"are" , "you" , d);	
		when(courserepo.save(course)).thenReturn(course);        

		courseservice.addCourse(course);
		courseservice.addCourse(course); 
		
	} 
	
	@Test
	public void deleteCourse() {
        MockitoAnnotations.initMocks(this);

		Long id = (long) 1;
		
		
		List<TrainerCourse> lt = new ArrayList<TrainerCourse>();
		TrainerCourse temp = new TrainerCourse((long)1,(long)2,(long)3      );
		lt.add(temp);
		temp = new TrainerCourse((long)2,(long)3,(long)4      );
		lt.add(temp);
		when(trainercourserepo.findByCourseid(id)).thenReturn(lt);
		
		courseservice.deleteCourse(id);
		
	}
	
	
	@Test
	public void getCourses() {
        MockitoAnnotations.initMocks(this);
        
        List<Course> temp = new ArrayList<Course>();
        Date d = new Date();
        temp.add(  
		 new Course((long)1, "hello" ,"how" ,"are" , "you" , d));
        temp.add(  
       		 new Course((long)2, "hello" ,"how" ,"are" , "you" , d));
        
        
        when( courserepo.findAll()).thenReturn(temp);
        courseservice.getCourses();
		
	}
	
	
	@Test
	public void updateCoursewithNonNull() {
        MockitoAnnotations.initMocks(this);

		Optional<Course> course; Long id;
		Date d = new Date();
		course = Optional.of(new Course((long)1, "hello" ,"how" ,"are" , "you" , d));
		id = (long) 1;
		
		
		when(courserepo.findById(id)).thenReturn(course);
		when( courserepo.save(course.get()) ).thenReturn(course.get());
		
		courseservice.updateCourse(course.get(), id);
		
		
	}
	
	@Test
	public void updateCoursewithNull() {
        MockitoAnnotations.initMocks(this);

		Optional<Course> course; Long id;
		Date d = new Date();
		course = Optional.of(new Course((long)1, "hello" ,"how" ,"are" , "you" , d));
		id = (long) 1;
		
		
		when(courserepo.findById(id)).thenReturn(Optional.empty());
		when( courserepo.save(course.get()) ).thenReturn(course.get());
		
		courseservice.updateCourse(course.get(), id);

		
		
	}
	
	

}
