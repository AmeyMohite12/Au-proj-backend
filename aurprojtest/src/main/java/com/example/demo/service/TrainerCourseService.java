package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepo;
import com.example.demo.dao.TrainerCourseRepo;
import com.example.demo.model.Course;
import com.example.demo.model.TrainerCourse;
import com.example.demo.model.Trend;

@Service
public class TrainerCourseService {
	
	@Autowired
	TrainerCourseRepo trainercourserepo;
	
	@Autowired
	CourseRepo courserepo;
	
	
	public List<Trend> getCourseData(){
		
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
		return temp1;
	}
	
	
	public void unAssignTrainer(Long tid , Long cid) {
		
		List<TrainerCourse> temp = trainercourserepo.findByTrainerid(tid);
	    Long var;
		for(TrainerCourse t : temp) {
			
			var = t.getCourseid();
			if(var.equals(cid)) {
				
				trainercourserepo.deleteById(t.getId());
				break;

			}
			
			
		}
	}
	
	public boolean getCoursesOfTrainer(Long tid , Long cid){
		
		List<TrainerCourse> trp;
		trp=  trainercourserepo.findByTrainerid(tid);
		for(TrainerCourse temp : trp) {
			if(temp.getCourseid().equals(cid)) {
				return false;
			}
		}
		return true;
	}
	
	
}
