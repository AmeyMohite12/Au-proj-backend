package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RequestMapping("/person")
@RestController
@CrossOrigin
public class PersonController {
	//@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	
	
	PersonService ps;
	
	@Autowired
	PersonController(PersonService ps){
		this.ps = ps;
	}
	
	@GetMapping("/get")
	public List<Person> getall(){
		return ps.getall();
	}
	
	@CrossOrigin
	@GetMapping("/get/{username}")
	public Person getPerson(@PathVariable String username){
		return ps.getPerson(username);
	}
	
	
	 
	
	@PostMapping("/post")
	public void addPerson(@RequestBody Person person) {
		ps.addPerson(person);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		ps.deletePerson(id);
	}
	
}
