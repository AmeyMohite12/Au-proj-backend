package com.example.demo.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.dao.TrainerCourseRepo;
import com.example.demo.dao.TrainerRepo;
import com.example.demo.model.Trainer;
import com.example.demo.model.TrainerCourse;


public class TrainerServiceTest {

	@Mock
	TrainerRepo trainerrepo;
	
	@Mock
	public TrainerCourseRepo trainercourserepo;
	
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
        MockitoAnnotations.initMocks(this);
        
        List<TrainerCourse> temp = new ArrayList<TrainerCourse>();
        TrainerCourse m = new TrainerCourse( (long) 1,  (long)2, (long)3);
        temp.add(m);
        m = new TrainerCourse( (long) 2,  (long)2, (long)3);
        temp.add(m);
        when( trainercourserepo.findByTrainerid((long)1  )).thenReturn(temp);
        trainerservice.deleteTrianer((long)1  );
        
	}
	
	@Test
	public void addTrainerTest() {
        MockitoAnnotations.initMocks(this);

		Trainer train = new Trainer( (long)1,"amey","type","gender","age");
		
		
		when( trainerrepo.save(train) ).thenReturn(train);
		trainerservice.addTrainer(train);
	}
	
	
	@Test
	public void updateTrainerNonNull() {
		MockitoAnnotations.initMocks(this);

		Optional<Trainer> train = Optional.of(new Trainer( (long)1,"amey","type","gender","age"));
		when(trainerrepo.findById((long)1 )).thenReturn(train);
		
		when(trainerrepo.save(train.get())).thenReturn(train.get());
		trainerservice.updateTrainer( train.get(),(long)1 );
		
	}
	
	
	@Test
	public void updateTrainerNull() {
		MockitoAnnotations.initMocks(this);

		Optional<Trainer> train = Optional.of(new Trainer( (long)1,"amey","type","gender","age"));
		when(trainerrepo.findById((long)1 )).thenReturn(Optional.empty());
		
		when(trainerrepo.save(train.get())).thenReturn(train.get());
		trainerservice.updateTrainer( train.get(),(long)1 );
		
	}
	
	
	@Test
	public void getTrainerByIdTestNonNull() {
	Optional<Trainer> train = Optional.of(new Trainer( (long)1,"amey","type","gender","age"));
		when( trainerrepo.findById( (long)1 )).thenReturn(train);
		
		trainerservice.getTrainerById( (long)1 );
	}
	
	@Test
	public void getTrainerByIdTestNull() {

		
		
		when( trainerrepo.findById( (long)1 )).thenReturn(null);
		
		
		trainerservice.getTrainerById( (long)1 );
	}
	
	
	
	
}
