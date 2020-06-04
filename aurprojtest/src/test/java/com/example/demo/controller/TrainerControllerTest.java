package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.TrainerService;

import com.example.demo.model.Trainer;
@SpringBootTest
@AutoConfigureMockMvc
class TrainerControllerTest {

	@MockBean
	TrainerService trainerservice;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
        List<Trainer> temp = new ArrayList<Trainer>();
        
		Trainer train = new Trainer( (long)1,"amey","type","gender","age");
		Trainer train1 = new Trainer( (long)1,"kavasbuth","type","gender","age");
		
		temp.add(train);
		temp.add(train1);
		
		when(trainerservice.getTrainers()).thenReturn(temp);
	}
	
	
	@Test
	public void getAllTrainersTest() throws Exception{
		
		mockMvc.perform(get("/trainer/get")).andDo(print()).andExpect(status().isOk());
		
		
		
	}
	
	
	
	
	
	
	
	
}
