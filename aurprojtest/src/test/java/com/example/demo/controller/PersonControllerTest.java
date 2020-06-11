package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dao.PersonRepo;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;


import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	@MockBean
	PersonService personservice;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
    }
	

	
	@Test
	public void findByUsernameTest() throws Exception {
		Person p =new Person( 1 , "amey" , "mohite" , "Amey"  );
        when(personservice.getPerson(p.getUsername())).thenReturn(p);
		
        
        
        mockMvc.perform(get("/person/get/amey")).andExpect(status().isOk());
	}
	
	
	@Test
	public void getallTest() throws Exception {
		Person p =new Person( 1 , "amey" , "mohite" , "Amey"  );
		Person p2 =new Person( 2 , "kavasbuth" , "gaikwad" , "K"  );
		List<Person> person = new ArrayList<Person>();
		person.add(p);
		person.add(p2);
		when(personservice.getall()).thenReturn(person);
		mockMvc.perform(get("/person/get")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void addPersonTest() throws Exception {
		Person p =new Person( 1 , "amey" , "mohite" , "Amey"  );
		
		mockMvc.perform(post("/person/post").content(asJsonString(p)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void deletePersonTest() throws Exception {
		mockMvc.perform(delete("/person/delete/1")).andExpect(status().isOk());
	}
	
	
	

}
