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
		
		verify(courserepo , times(2)).save(course);
	}
	
//	
//	@Test
//	public void deleteCourseTest() {
//		
//		List<TrainerCourse> temp = new ArrayList<TrainerCourse>();
// 		TrainerCourse ct1 = new TrainerCourse( (long) 1, (long)2, (long)3);
// 		TrainerCourse ct2 = new TrainerCourse( (long) 2, (long)2, (long)4);
//        Date d = new Date();
//        temp.add(ct1);
//        temp.add(ct2);
//		Course course = new Course((long)1, "hello" ,"how" ,"are" , "you" , d);
// 		
//		
//	//	when(((OngoingStubbing< List<TrainerCourse> >) trainercourserepo.findByCourseid((long)1)).thenReturn(temp));
//		
//		
//		courseservice.deleteCourse((long)1);
//		
//		
// 		verify(courserepo,times(1)).deleteById((long) 1);
// 		
//	}

}
