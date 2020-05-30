package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Material;

public interface MaterialRepo extends CrudRepository<Material,Long> {

}
