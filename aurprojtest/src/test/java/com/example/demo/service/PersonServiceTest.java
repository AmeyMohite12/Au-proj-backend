package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.dao.PersonRepo;
import com.example.demo.model.Person;


public class PersonServiceTest {

	@Mock
	PersonRepo personrepo;
	
	@InjectMocks
	PersonService personservice;
	
	 @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	        Person p1 = new Person(1,"hello","world","hi");
			Person p2 = new Person(2,"hell","d","hi");
			List<Person> parray= new ArrayList<Person>();
			parray.add(p1);
			parray.add(p2);
			
			when(personrepo.findAll()).thenReturn(parray);
			when(personrepo.findByUsername("hello")).thenReturn(p1);
		
			
	 }
	
	@Test
	public void getallPersonTest() {
		
		
		List<Person> arr = personservice.getall();
		assertEquals(arr.size() , 2);
		
	
	}
	
	
	@Test
	public void getPersonTest() {
		
		Person p  = personservice.getPerson("hello");
		assertEquals(p.getUsername() , "hello");
	}
	
	@Test
	public void deletePersonTest() {
		int id = 1;
		personservice.deletePerson(1);
		personservice.deletePerson(1);
		verify(personrepo,times(2)).deleteById(1);
	}
	

}
