package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import com.example.demo.model.Material;
import com.example.demo.model.Materialversion;
import com.example.demo.model.Person;
import com.example.demo.service.MaterialService;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@AutoConfigureMockMvc
class MaterialControllerTest {

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@MockBean
	MaterialService ms;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
    }
	
	
	@Test
	public void addCourseTest() throws Exception {
		Date d = new Date();
		Material m = new Material( (long)1,"hello", d,  "amey"  );
		
		
		mockMvc.perform(post("/material/post").content(asJsonString(m)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	
	@Test
	public void updateMaterialTest() throws Exception {
		Date d = new Date();
		Material m = new Material( (long)1,"hello", d,  "amey"  );
		
		
		mockMvc.perform(post("/material/update/1").content(asJsonString(m)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
			
	}

	@Test
	public void deleteMaterialTest() throws Exception {
		mockMvc.perform(delete("/material/delete/1"  )).andExpect(status().isOk()).andReturn();
		
	}
	
	
	@Test
	public void getMaterial() throws Exception {
		Date d = new Date();
		Material m;
		m = new Material( (long)2,"hello", d,  "amey"  );
		
		List<Material> lt = new ArrayList<Material>();
		lt .add(m);
		m = new Material( (long)1,"hello", d,  "amey"  );
		lt.add(m);
		
		when(ms.getMaterial()).thenReturn(lt);
		
		mockMvc.perform(get("/material/get")).andExpect(status().isOk());
		
	}
	
	@Test
	public void getMaterialVersion() throws Exception {
		Date d = new Date();
		Materialversion m;
		m = new Materialversion((long)1,"hello",(long)2,"yep",d  );
		
		List<Materialversion> lt = new ArrayList<Materialversion>();
		lt .add(m);
		m = new Materialversion((long)2,"hello",(long)3,"yep",d  );
		lt.add(m);
		
		when(ms.getVersions( (long)1 )).thenReturn(lt);
		
		mockMvc.perform(get("/material/get/1")).andExpect(status().isOk());
		
	}
	
	
	
	
}
