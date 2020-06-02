package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ResponseDataVersion;

public interface ResponseDataVersionRepo extends CrudRepository<ResponseDataVersion,Long>{
			
	
	public List<ResponseDataVersion> findByResponseid(Long responseid);
	
}
