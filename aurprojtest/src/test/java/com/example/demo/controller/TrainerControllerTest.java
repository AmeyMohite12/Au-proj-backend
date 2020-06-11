package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.TrainerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.model.Trainer;
@SpringBootTest
@AutoConfigureMockMvc
class TrainerControllerTest {

	@MockBean
	TrainerService trainerservice;
	
	@Autowired
	MockMvc mockMvc;
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	  
	
	@Test
	public void getAllTrainersTest() throws Exception{
        MockitoAnnotations.initMocks(this);
        List<Trainer> temp = new ArrayList<Trainer>();
        
      		Trainer train = new Trainer( (long)1,"amey","type","gender","age");
      		Trainer train1 = new Trainer( (long)1,"kavasbuth","type","gender","age");
      		
      		temp.add(train);
      		temp.add(train1);
      		
      		when(trainerservice.getTrainers()).thenReturn(temp);
		mockMvc.perform(get("/trainer/get")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void deleteTrainerTest() throws Exception {
		Long id = (long)1;
		mockMvc.perform( delete("/trainer/delete/1") ).andExpect(status().isOk());
		
	}
	
	@Test
	public void getTrainerById() throws Exception{
        MockitoAnnotations.initMocks(this);
        Optional<Trainer> lt = Optional.of(new Trainer( (long)1,"hello","hello","hello","jhello" )) ;
       
		Long id = (long)1;
		
		when(trainerservice.getTrainerById(id)).thenReturn(lt);
		mockMvc.perform( get("/trainer/get/1") ).andExpect(status().isOk());
		
		
	}
	
	@Test
	public void addTrainerTest() throws Exception {
		Trainer train = new Trainer( (long)1,"amey","type","gender","age");
		
		mockMvc.perform(post("/trainer/post").content(asJsonString(train)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
	}
	 
	
	@Test
	public void updateTrainerTest() throws Exception {
Trainer train = new Trainer( (long)1,"amey","type","gender","age");
		
		mockMvc.perform(post("/trainer/update/1").content(asJsonString(train)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	
	
	
	
	
}
