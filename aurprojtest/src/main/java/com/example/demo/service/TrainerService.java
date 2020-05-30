package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TrainerRepo;
import com.example.demo.model.Trainer;
@Service
public class TrainerService {
	
	public TrainerRepo trainerrepo;
	
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
	}
	
	public void addTrainer(Trainer trainer) {
		trainerrepo.save(trainer);
	}
	
	
	
	
	
	
	
	
	
}
