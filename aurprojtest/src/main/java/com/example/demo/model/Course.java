package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String creator;
	
	public Course() {
		
	}
	
	
	public Long getid() {
		return id;
	}
	public Course(Long id, String description, String creator) {
		super();
		this.id = id;
		this.description = description;
		this.creator = creator;
	}
	public void setCourseId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}
