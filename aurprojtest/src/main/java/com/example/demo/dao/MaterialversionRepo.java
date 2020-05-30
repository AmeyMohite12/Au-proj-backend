package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Materialversion;

public interface MaterialversionRepo extends CrudRepository<Materialversion,Long>{
		
	public List<Materialversion> findByMaterial(Long material);
	
	
}
