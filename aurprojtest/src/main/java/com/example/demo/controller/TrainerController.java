package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Trainer;
import com.example.demo.service.TrainerService;

@RestController
@RequestMapping("/trainer")
@CrossOrigin
public class TrainerController {
	
	public TrainerService trainerserivce;
	
	@Autowired
	TrainerController(TrainerService trainerservice){
		this.trainerserivce = trainerservice;
	}
	
	
	@GetMapping("/get")
	public List<Trainer> getTrainers() {
		return trainerserivce.getTrainers();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Trainer> getTrainerById(@PathVariable Long id) {
		return trainerserivce.getTrainerById(id);
	}
	
	@PostMapping("/update/{id}")
	public void updateTrainer( @RequestBody Trainer trainer ,@PathVariable Long id ) {
		trainerserivce.updateTrainer(trainer, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTrianer(@PathVariable Long id) {
		trainerserivce.deleteTrianer(id);
	}
	
	@PostMapping("/post")
	public void addTrainer(@RequestBody Trainer trainer)
	{
		trainerserivce.addTrainer(trainer);
	}
	
}
