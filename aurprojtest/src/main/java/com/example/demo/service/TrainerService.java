package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TrainerCourseRepo;
import com.example.demo.dao.TrainerRepo;
import com.example.demo.model.Trainer;
import com.example.demo.model.TrainerCourse;
@Service
public class TrainerService {
	
	public TrainerRepo trainerrepo;
	
	@Autowired
	public TrainerCourseRepo trainercourserepo;
	
	@Autowired
	TrainerService(TrainerRepo trainerrepo){
		this.trainerrepo = trainerrepo;
	}
	
	
	public List<Trainer> getTrainers() {
		return (List<Trainer>)trainerrepo.findAll();
	}
	
	public Optional<Trainer> getTrainerById(Long id) {
		if(trainerrepo.findById(id) != null) {
			return trainerrepo.findById(id);
		}
		else
			return null;
	}
	
	public void updateTrainer( Trainer trainer , Long id ) {
		trainerrepo.findById(id).map( trn ->{
			trn.setAge(trainer.getAge());
			trn.setGender(trainer.getGender());
			trn.setName(trainer.getName());
			trn.setType(trainer.getType());
			trn.setId(trainer.getId());
			return trainerrepo.save(trn);
		}).orElseGet(()->{
			trainer.setId(id);
			return trainerrepo.save(trainer);
		});
	}
	
	public void deleteTrianer(Long id) {
		trainerrepo.deleteById(id);
		List<TrainerCourse> temp = trainercourserepo.findByTrainerid(id);
		for(TrainerCourse t : temp) {
			trainercourserepo.deleteById(t.getId());
		}
		
		
	}
	
	public void addTrainer(Trainer trainer) {
		trainerrepo.save(trainer);
	}
	
	
	
	
	
	
	
	
	
}
