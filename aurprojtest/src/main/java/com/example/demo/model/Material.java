package com.example.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Material {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@UpdateTimestamp
	private Date lastupdated;
	
	private String creator;
	
	public String getCreator() {
		return creator;
	}


	public void setCreator(String creator) {
		this.creator = creator;
	}


	Material(){}
	
	
	public Material(Long id, String name, Date lastupdated , String creator) {
		super();
		this.id = id;
		this.name = name;
		this.lastupdated = lastupdated;
		this.creator = creator;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Date getlastupdated() {
		return lastupdated;
	}
	public void setlastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	
}
