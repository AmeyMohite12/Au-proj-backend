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

import com.example.demo.dao.TrainerRepo;
import com.example.demo.model.Trainer;


public class TrainerServiceTest {

	@Mock
	TrainerRepo trainerrepo;
	
	@InjectMocks
	TrainerService trainerservice;
	
	
	
	
	
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        List<Trainer> temp = new ArrayList<Trainer>();
		Trainer train = new Trainer( (long)1,"amey","type","gender","age");
		
		temp.add(train);
		when(trainerrepo.findAll()).thenReturn(temp);

	}
	
	@Test
	public void getallTest() {
		List<Trainer> t1 = trainerservice.getTrainers();
		assertEquals(t1.size(),1);
	}
	
	
	@Test
	public void deleteTrainerTest() {
		trainerservice.deleteTrianer( (long) 1);
		trainerservice.deleteTrianer((long) 1);
		
		verify(trainerrepo,times(2)).deleteById( (long) 1);
	}
	
	
	
	
}
