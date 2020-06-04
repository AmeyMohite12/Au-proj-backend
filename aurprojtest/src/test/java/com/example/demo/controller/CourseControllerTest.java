package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;




@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	CourseService courseservice;
	
	
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
        Date d = new Date();
		Course course = new Course((long)1, "hello" ,"how" ,"are" , "you" , d); 
		Course course2 = new Course((long)1, "nope" ,"how" ,"are" , "you" , d);        

		List<Course> temp = new ArrayList<Course>();
		
		temp.add(course);
		temp.add(course2);
		
		when(courseservice.getCourses()).thenReturn(temp);
	}
	
	
	@Test
	public void getCoursesTest() throws Exception {
		mockMvc.perform(get("/course/get")).andExpect(status().isOk());
	}
	
	@Test
	public void addCourseTest() throws Exception{
		Date d = new Date();
		Course course = new Course((long)1, "hello" ,"how" ,"are" , "you" , d); 
		mockMvc.perform(post("/course/post").content(asJsonString(course)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	
	

}
