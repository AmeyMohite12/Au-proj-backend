package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface PersonRepo extends CrudRepository<Person, Integer> {
	public Person findByUsername(String username);
}
