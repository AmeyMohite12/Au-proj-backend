package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Dummyfile;

public interface DummyfileRepo extends JpaRepository<Dummyfile,Long> {

}
