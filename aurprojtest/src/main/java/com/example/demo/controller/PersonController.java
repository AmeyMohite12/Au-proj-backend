package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@PostMapping("/post")
	public void addPerson(@RequestBody Person person) {
		ps.addPerson(person);
	}
	
	
}