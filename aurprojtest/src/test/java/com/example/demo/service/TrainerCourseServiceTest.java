package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.example.demo.model.Trend;

public class TrainerCourseServiceTest {
	@Mock
	TrainerCourseRepo trainercourserepo;

	@Mock
	CourseRepo courserepo;
	
	@InjectMocks
	TrainerCourseService tcs;
	
	
	@SuppressWarnings("unchecked")
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        List<TrainerCourse> temp = new ArrayList<TrainerCourse>();
        TrainerCourse obj = new TrainerCourse((long)1 ,(long)2 ,(long)3 );
        temp.add(obj);
        obj = new TrainerCourse((long)2 ,(long)6 ,(long)3 );
        temp.add(obj);
        when(trainercourserepo.findByTrainerid((long)3)).thenReturn(temp);
      
        
        
        
        Date d = new Date();
		Course course = new Course((long)1, "hello" ,"how" ,"are" , "you" , d);
		List<Course> coursetemp = new ArrayList<Course>();
		coursetemp.add(course);
		 course = new Course((long)2, "not" ,"how" ,"are" , "you" , d);
		 coursetemp.add(course);
		 
		 when(courserepo.findAll()).thenReturn((Iterable<Course>) coursetemp);
		 
		 when(trainercourserepo.existsByCourseid( (long)1  )).thenReturn(true);
		 when(trainercourserepo.existsByCourseid( (long)2 )).thenReturn(false);
		 when( trainercourserepo.findByCourseid( (long)1)).thenReturn(temp);
		 
	}
	
	@Test
	public void unAssignTrainerTest() {
		Long cid = (long)6;
		Long tid = (long)3;
		List<TrainerCourse> temp = trainercourserepo.findByTrainerid(tid);
	    Long var;
		for(TrainerCourse t : temp) {
			var = t.getCourseid();
			if(var.equals(cid)) {
				trainercourserepo.deleteById(t.getId());
				break;
			}
		}
		verify(trainercourserepo,times(1)).deleteById((long)2);
		assertEquals(temp.size(),2);
		tcs.unAssignTrainer( tid , cid);
		
	
		
		
		
		
	}
	
	
	@Test
	public void getCourseData() {
		
				List<Trend> temp1 = new ArrayList<Trend>();
			
			List<Course> temp = (List<Course>) courserepo.findAll();
			Long count;
			for(Course c : temp) {
				if(trainercourserepo.existsByCourseid(c.getid())) {
						count = (long) trainercourserepo.findByCourseid(c.getid()).size();
						temp1.add( new Trend( c.getDescription() , count )  );
				}else {
					temp1.add( new Trend( c.getDescription() ,(long) 0 )  );
				}
			}
			assertEquals( temp1.size() , 2);
			tcs.getCourseData();
			
	}
	
}
