package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.dao.MaterialRepo;
import com.example.demo.dao.MaterialversionRepo;
import com.example.demo.model.Material;
import com.example.demo.model.Materialversion;

public class MaterialServiceTest {
	
	
	
	@Mock
	MaterialRepo materialrepo;
	@Mock
	MaterialversionRepo materialverrepo;
	
	
	@InjectMocks
	MaterialService ms;
	
	
	
	
	
	@Test
	public void getMaterialTest() {
		  MockitoAnnotations.initMocks(this);


		  List<Material> mt = new ArrayList<Material>();
		  Date d = new Date();
		  Material m = new Material((long) 1,"2",d,"amey");
		  
		  mt.add(m);
		  m = new Material((long) 2,"2",d,"vineet");
		  mt.add(m);

		  
		  when(materialrepo.findAll()).thenReturn((Iterable<Material>) mt);	
		
		List<Material> t = ms.getMaterial();
			assertEquals(t.size() , 2);
	}
	
	
	@Test
	public void getVersionsTest() {
		  MockitoAnnotations.initMocks(this);

		Long id = (long)1;
		 Date d = new Date();
	
		List<Materialversion> li  = new ArrayList<Materialversion>();
		
		
		Materialversion obj = new Materialversion( (long)1 , "hello",(long)2 , "amey" ,d  );
		li.add(obj);
		
		obj =  new Materialversion( (long)2 , "hello",(long)2 , "amey" ,d  );
		li.add(obj);
		
		when(materialverrepo.findByMaterial( (long)1)).thenReturn(li);
		
		li = ms.getVersions((long)1);
		
		assertEquals(li.size(), 2);
		
	}
	
	
	@Test
	public void deleteMaterialTest() {
		  MockitoAnnotations.initMocks(this);

		Long id = (long) 1;
		 Date d = new Date();
			
			List<Materialversion> li  = new ArrayList<Materialversion>();
			
			
			Materialversion obj = new Materialversion( (long)1 , "hello",(long)2 , "amey" ,d  );
			li.add(obj);
			
			obj =  new Materialversion( (long)2 , "hello",(long)2 , "amey" ,d  );
			li.add(obj);
			when(materialverrepo.findByMaterial( (long)1)).thenReturn(li);
			
			
			ms.deleteMaterial( (long) 1);
	}
	
	@Test
	public void addMaterialTest() {
		  MockitoAnnotations.initMocks(this);

		
		Date d = new Date();
		Material m =  new Material((long) 1,"2",d,"amey");
		
		Materialversion temp1;
		temp1 = new Materialversion( null , m.getName() , m.getId() , m.getCreator(),null );
		
		when(materialrepo.save(m)).thenReturn(m);
		
		when(materialverrepo.save(temp1)).thenReturn(temp1);
		
		ms.addMaterial(m);
		
	}
	
	
	@Test
	public void updateMaterialTestWithNonNull() {
		  MockitoAnnotations.initMocks(this);
		  
		  Date d = new Date();
			Optional<Material> m =  Optional.of(new Material((long) 1,"2",d,"amey"));
			when(materialrepo.findById((long)1  )).thenReturn(m);
			when(materialrepo.save(m.get())).thenReturn(m.get());
			Materialversion temp1;
			temp1 = new Materialversion( m.get().getId() ,  m.get().getName() ,  m.get().getId() ,  m.get().getCreator(),null );
			when(materialverrepo.save(temp1)).thenReturn(temp1);
			ms.updateMaterial((long)1,m.get());
	}
	
	@Test
	public void updateMaterialTestWithNull() {
		  MockitoAnnotations.initMocks(this);
		  
		  Date d = new Date();
		  Material m =  new Material((long) 1,"2",d,"amey");
		when(materialrepo.findById((long)1  )).thenReturn(Optional.empty());
		when(materialrepo.save(m)).thenReturn(m);
		Materialversion temp1;
		temp1 = new Materialversion( m.getId() ,   m.getName() ,   m.getId() ,  m.getCreator(),null );
		when(materialverrepo.save(temp1)).thenReturn(temp1);
		ms.updateMaterial((long)1,m);
	}
	
	
	
}
