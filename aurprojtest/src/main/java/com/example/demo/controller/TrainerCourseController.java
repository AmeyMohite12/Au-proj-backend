package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.demo.dao.CourseRepo;
import com.example.demo.dao.TrainerCourseRepo;
import com.example.demo.dao.TrainerRepo;
import com.example.demo.model.Trainer;
import com.example.demo.model.TrainerCourse;
import com.example.demo.service.CourseService;
import com.example.demo.service.TrainerService;

import com.example.demo.model.Course;


@RequestMapping("/trainer_course")
@RestController
@CrossOrigin
public class TrainerCourseController {
	@Autowired
	private CourseRepo cr;
	@Autowired
	private TrainerRepo tr;
	
	/// since no service make repo here
	@Autowired
	private TrainerCourseRepo tcrp;
	
	
	@GetMapping("/trainer/get/{tid}")
	public List<Course> getCoursesOfTrainer(@PathVariable("tid") Long tid  ){
		
		//TO DO:- Handle invalid trainer id case
		List<TrainerCourse> ltc = tcrp.findByTrainerid(tid);
		List<Course> course = new ArrayList<Course>();
		for(TrainerCourse temp : ltc) {
			course.add( (cr.findById(temp.getCourseid())).get()  );
		}
		return course;
	}
	
	@GetMapping("/course/get/{cid}")
	public List<Trainer> getTrainersOfCourse(@PathVariable("cid") Long cid  ){
		
		//TO DO:- Handle invalid trainer id case
		List<TrainerCourse> ltc = tcrp.findByCourseid(cid);
		List<Trainer> trainer = new ArrayList<Trainer>();
		for(TrainerCourse temp : ltc) {
			trainer.add( (tr.findById(temp.getTrainerid())).get()  );
		}
		
		return trainer;
		
	}
	@CrossOrigin
	@PostMapping("/post/{tid}/{cid}")
	public TrainerCourse assignCourseToTrainer(@PathVariable("tid") Long tid , @PathVariable("cid") Long cid) {
		
		boolean flg = cr.existsById(cid);
		if(flg) {
			
			TrainerCourse obj = new TrainerCourse(null , cid,tid);
			return tcrp.save(obj);
		}
		System.out.println("No object created");
		return null;
		
		
		
	}
}