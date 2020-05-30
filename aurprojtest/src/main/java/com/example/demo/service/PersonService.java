package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonRepo;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	private PersonRepo personrepo;
	
	@Autowired
	public PersonService(PersonRepo personrepo){
		this.personrepo = personrepo;
	}
	
	
	
	public void addPerson(Person person){
		personrepo.save(person);
	}
	
	public List<Person> getall(){
		return (List<Person>) personrepo.findAll();
	}
	
	public void deletePerson(int id) {
		personrepo.deleteById(id);
	}
	
	
	public Person getPerson(String username) {
		return personrepo.findByUsername(username);
	}
	
	
}
